package com.fuqiang.lan.cm.client;

import java.io.IOException;
import java.net.Socket;

import com.fuqiang.lan.cm.receive.Receive;
import com.fuqiang.lan.cm.send.Send;
import com.fuqiang.lan.view.ui.login.userlist.UserList;
/**
 * �ͻ���
 * @author Administrator
 *
 */
public class Client {
	private Socket socket;
	private Receive receive;
	public Send send;
	public Client(String name){
		try {
			//�����Ҫ�����������Եķ�����   ��Ҫ��   localhost ��Ϊ ��������ip  ��  192.168.1.1�����˷�����    ������͸�Ϊ192.168.1.1
			socket = new Socket("localhost",8888);
			//��������
			//��������
			
			this.send = new Send(socket);
			receive = new Receive(name,this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�����߳�
	public void start(){
		new Thread(receive).start();
	}
	//����
	public String request(String request){
		send.send(request);
		//��������
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