package com.fuqiang.servers.sm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fuqiang.servers.entity.User;
import com.fuqiang.servers.ud.DomUserList;
import com.fuqiang.servers.um.UserManager;
import com.fuqiang.servers.view.ui.SocketJFrame;

public class Server{
	
	private static ExecutorService threadPools=Executors.newFixedThreadPool(10);
	public static Map<String,ServerThread> map=new HashMap<>();
	public static Boolean bool=true;
	static ServerSocket ss;
	public static void start(int port){

		try{
			ss =new ServerSocket(port);
			System.out.println("服务器已启动");
			while(true){
				Socket s=ss.accept();
				BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String string=br.readLine();
				String[] user= splitTest(string);
				String name=user[0];
				String hintstr=name+"上线了";
				System.out.println(hintstr);
				if(string.startsWith("@userRegister#")){
					boolean bool = judge(string, s);
					if(bool == true){
						DomUserList.refresh();
					}
					s.close();
					continue;
				}else if(string.startsWith("@userLogin#")){
					//判断能否登录成功
					boolean login = judge(string,s);
					if(login == false){
						s.close();
						continue;
					}
				}	
				System.out.println("登录成功！");
				SocketJFrame server = SocketJFrame.socketlist.get(0);
				server.setVisible(true);
				//在线人
				String userList=br.readLine();
				//用户列表显示
				judge(userList,s);
				//为该用户提供线程
				ServerThread newThread=new ServerThread(s,name);
				//上线提示
				newThread.readWriter("@online"+name);
				map.put(name, newThread);
				threadPools.submit(newThread);	
			}
		} catch (IOException e) {
			DomUserList.refresh();
		}finally {
			threadPools.shutdown();
		}
	}
	
	//切分用户信息
	public static String[] splitTest(String str){
		String tempstr=str.split("#")[1];
		String[] user=tempstr.split("&");
		for (String string : user) {
			System.out.println(string);
		}
		return user;
	}
	//判断登录状态
	public static boolean judge(String str,Socket socket){
		if(str.startsWith("@userLogin")){
			boolean boolLogin = false ;
			try {
				boolLogin = login(str,socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return boolLogin;
 		}else if(str.startsWith("@userList")){
			try {
				onlie(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}else if(str.startsWith("@userRegister#")){
			boolean bool=register(str);
			if(bool){
				writerR(socket,"true");
			}else{
				writerR(socket,"false");
			}
			return bool;
		}
		return false;
	}
	private static void writerR(Socket socket, String string) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
		
			bw.write(string);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//用户列表
	public static void onlie(Socket socket) throws IOException{

		StringBuilder builder=new StringBuilder();
		Set<String> keys = Server.map.keySet();
		if(keys.isEmpty()){
			writerR(socket,"@userList#"+"当前无用户");
			return;
		}
		for(Iterator<String> iter = keys.iterator();iter.hasNext();){
			String name = iter.next();
			builder.append(name+",");
		}
		System.out.println("@userList#"+builder.substring(0, builder.length()-1));
		writerR(socket,"@userList#"+builder.substring(0, builder.length()-1));
	}
	public static Object[] userList(){
		Set<String> keys = Server.map.keySet();
		
		return keys.toArray();
	}

	private static boolean login(String str,Socket socket) throws IOException{
		String[] user=splitTest(str);
			String username=user[0];
		String password=user[1];
		User result=UserManager.querySingUser(username);
		
		if(result==null){
			writerR(socket,"false");
			return false;
		}else if(result.getUserPassword().equals(password)){
			
			writerR(socket,"true");
			return true;
		}
		return false;
	}
	private static boolean register(String str){
		String[] user=splitTest(str);
		String username=user[0];
		String password=user[1];
		User us=new User(username,password);
		boolean bool=UserManager.addUser(us);
		System.out.println(bool);
		return bool;
	}
	public static void close(JFrame jf){
		try {
			ss.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(jf,"请勿重复关闭"); 
		}
	}
}
