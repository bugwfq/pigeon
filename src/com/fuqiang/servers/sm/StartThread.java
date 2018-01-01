package com.fuqiang.servers.sm;


public class StartThread extends Thread{
	public int port;
	public StartThread(int port){
		this.port = port;
	}
	@Override
	public void run() {
		  Server.start(port);
	}
}
