package com.fuqiang.servers.sm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class ServerThread extends Thread{
	private BufferedReader br;
	private BufferedWriter bw;
	private Socket s;
	private String username;
	public  boolean isFile = false;
	public ServerThread(){}
	
	public ServerThread(Socket s,String username){
		
		
		this.s=s;
		this.username=username;
		try {
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
		}
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println("服务端开始读。。。。");
			String message = reader();
			if(message == null){
				return;
			}
			if(message.equals("@back")){
				return;
			}
			if(message.startsWith("@filesStart#")){
				readWriter(message);
				System.out.println("文件发送成功！！       run");
			}else{
				readWriter(message);
			}
			
		}
		
	}
	public String reader(){
		
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			writerAll("@back"+username); 
			Server.map.remove(username);
			return "@back";
		}
		return str;
	}
	public void writer(String message){
		try {
			bw.write(message);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("ServerThread      ++++     62行");
		}
		
	}
	public void readWriter(String message){
		if(message == null){
			return;
		}
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String date = form.format(new Date());
		
		if(message.startsWith("@:")){ 
			//@:"+name+"##"+message  "
			String[] msr = message.split("##");
			String receiveName = msr[0].replace("@:", "");

			if(msr.length > 1){
				message = msr[1];
			}
			ServerThread privateU = Server.map.get(receiveName);
			if(privateU == null){
				return;
			}
			privateU.writer("@:"+username+"##"+date+"##"+message);

		}
		if(message.startsWith("@all:")){
			//发送过来的格式       @all:"+message.trim()
			message = message.replace("@all:", "");
			String str = "@all:"+username+"##"+date+"##"+message;
			writerAll(str);
		}else if(message.startsWith("@online")){
			writerAll(message);
		}else if(message.startsWith("@filesStart#")){
			//收到的格式    "@filesStart#"+file.getName()+"#"+message
			String fileName = message.split("#")[1];
			File file = new File("src/"+fileName);
			long length = Integer.valueOf(message.split("#")[2]);
			writerFileToServer(file,length);
			writerAll(message);
			writerFileAll(file);
			File deleteFile = new File("src/"+fileName);
			deleteFile.delete();
		}else if(message.startsWith("@filesTo&")){
			//收到的格式     "@filesTo&"+name+"&#"+file.getName()+"#"+message
			String name = message.split("&")[1];
			String fileName = message.split("#")[1];
			File file = new File("src/"+fileName);
			long length = Integer.valueOf(message.split("#")[2]);
			ServerThread privateU = Server.map.get(name);
			if(privateU == null){
				return;
			}
			message = message.replaceAll("@filesTo&"+name+"&#", "@filesStart#");
			privateU.writer(message);
			writerFileToServer(file,length);
			try {
				writerFile(file,privateU.s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	private void writerFileToServer(File file,long l){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(s.getInputStream(),6000000);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] files = new byte[3000000];
			long fileLength = 0;
			int length = 0;
			while((length = bis.read(files))!=-1){
				bos.write(files,0,length);
				fileLength = fileLength+length;
				if(fileLength == l){
					break;
				}
			}
			bos.flush();
		} catch (IOException e1) {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void writerFileAll(File file){
		Set<String> keys = Server.map.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String keyName = iter.next();
			ServerThread thread = Server.map.get(keyName);
			if(username == keyName){
				continue;
			}
			try {
				writerFile(file, thread.s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void writerFile(File file, OutputStream out) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(out);
				byte[] files = new byte[3000000];
				int length = 0;
				while((length = bis.read(files))!=-1){
					System.out.println("正在发。。。。。。。");
					bos.write(files,0,length);
				}
				bos.flush();
			} catch (IOException e1) {
				System.out.println("serverThread");
				try {
					bis.close();
					bos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
	}
	private void writerAll(String message) {
		Set<String> keys = Server.map.keySet();
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String keyName = iter.next();
			ServerThread thread = Server.map.get(keyName);
			if(username == keyName){
				continue;
			}
			thread.writer(message);
		}
	}
}
