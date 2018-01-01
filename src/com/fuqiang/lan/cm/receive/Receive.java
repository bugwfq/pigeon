package com.fuqiang.lan.cm.receive;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fuqiang.lan.cm.client.Client;
import com.fuqiang.lan.cm.tools.CloseUtil;
import com.fuqiang.lan.view.ui.PrivateUserProcedureJFrame;
import com.fuqiang.lan.view.ui.ProcedureJFrame;
import com.fuqiang.lan.view.ui.UsersJFrame;
import com.fuqiang.lan.view.ui.login.userlist.UserList;



public class Receive extends Thread implements ReceiveInterface{
	//输入流
	
	private static boolean isRunnable=true;
	public String UsersJFrameName;
	private Client client;
	private BufferedReader br;
	private BufferedInputStream bis;
	public Receive(String UsersJFrameName,Client client) {
		
		this.UsersJFrameName = UsersJFrameName;
		this.client = client;
		try {
			bis = new BufferedInputStream(client.getSocket().getInputStream(),6000000);
		} catch (IOException e1) {
			isRunnable = false;
			CloseUtil.closeAll(br);
		}
		
		br = new BufferedReader(new InputStreamReader(bis));
		
	}
	//接受数据
	public String receive(){
		String msg = null;
		try {
			msg=br.readLine();
		} catch (IOException e){
			isRunnable = false;
			CloseUtil.closeAll(br);
		}
		return msg;
	}

	@Override
	public void run() {
		while(isRunnable){
			System.out.println("开始读");
			String message = receive();
			if(message == null){
				continue;
			}
			if(message.startsWith("@:")){
				//发送过来的格式        "@:"+username+"##"+date+"##"+message
				String[] messages = message.replace("@:", "").split("##");
				
				String name = messages[0];
				PrivateUserProcedureJFrame privateU=PrivateUserProcedureJFrame.privateUserJFame.get(name);
				if(privateU == null){
					privateU = new PrivateUserProcedureJFrame(name,UsersJFrameName,client);
					PrivateUserProcedureJFrame.privateUserJFame.put(name, privateU);
				}
				String body = name+"	"+messages[1]+"\r\n"+messages[2];
				privateU.getJTextArea1().append(body+"\r\n");
				privateU.setVisible(true);
			}else if(message.startsWith("@all:")){
				
				//发送过来的格式      "@all:"+username+"##"+date+"##"+message; 
				
				String[] messages = message.replace("@all:", "").split("##");
				String name = messages[0];
				ProcedureJFrame users = ProcedureJFrame.userListJFame.get(UserList.obj[0].toString());
				if(users == null){
					users = new ProcedureJFrame(UserList.obj[0].toString(),UsersJFrameName,client);
					ProcedureJFrame.userListJFame.put(UserList.obj[0].toString(), users);
				}
				String body=null;
				if(messages.length>2){
					body = name+"	"+messages[1]+"\r\n"+messages[2];
				}else{
					body = name+"	"+messages[1]+"\r\n"+"";
				}
				
				users.getJTextArea().append(body+"\r\n");
				users.setVisible(true);
			}else if(message.startsWith("@online")){
				String name = message.replace("@online", "");
				UserList.add(name);
				UserList.delete("当前无用户");
				UsersJFrame my = UsersJFrame.users.get(UsersJFrameName);
				my.setUserList();
				my.setVisible(true);
			}else if(message.startsWith("@back")){
				String name = message.replace("@back", "");
				UserList.delete(name);
				UsersJFrame my = UsersJFrame.users.get(UsersJFrameName);
				System.out.println(my);
				my.setUserList();
				my.setVisible(true);
			}else if(message.startsWith("@filesStart#")){
				String fileName = message.split("#")[1];
				File file = new File("D:\\"+fileName);
				long length = Integer.valueOf(message.split("#")[2]);
				receiveFile(length,file);
			}
		}
	}
	public void receiveFile(long l,File file){
		//收到的格式    "@filesStart#"+file.getName()+"#"+message
		
		BufferedOutputStream bos = null;
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] files = new byte[8046];
			int length = 0;
			long fileLength = 0;
			while((length = bis.read(files))!=-1){
				System.out.println("正在收。。。。。。。");
				bos.write(files,0,length);
				fileLength = fileLength+length;
				if(fileLength == l){
					break;
				}
			}
			bos.flush();
		} catch (IOException e1) {
			
			try {
				bos.flush();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Receive close");
		}
	}
}
