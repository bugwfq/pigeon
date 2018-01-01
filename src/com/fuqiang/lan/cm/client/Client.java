package com.fuqiang.lan.cm.client;

import java.io.IOException;
import java.net.Socket;

import com.fuqiang.lan.cm.receive.Receive;
import com.fuqiang.lan.cm.send.Send;
import com.fuqiang.lan.view.ui.login.userlist.UserList;
/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
	private Socket socket;
	private Receive receive;
	public Send send;
	public Client(String name){
		try {
			//如果需要连接其他电脑的服务器   需要将   localhost 改为 服务器的ip  如  192.168.1.1启动了服务器    则这里就改为192.168.1.1
			socket = new Socket("localhost",8888);
			//发送数据
			//接受数据
			
			this.send = new Send(socket);
			receive = new Receive(name,this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动线程
	public void start(){
		new Thread(receive).start();
	}
	//请求
	public String request(String request){
		send.send(request);
		//接受数据
		String login = receive.receive();
		return login;
	}
	
	public Socket getSocket(){
		return socket;
	}
	
	
	public void close(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}