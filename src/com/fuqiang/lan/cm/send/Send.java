package com.fuqiang.lan.cm.send;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.fuqiang.lan.cm.tools.CloseUtil;


public class Send implements SendInterface{
	
	private Socket client;
	//管道输出流
	private BufferedWriter bw;
	
	private static boolean isRunnable = true;
	//构造器初始化

	public Send(Socket client) {
		this.client=client;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			isRunnable = false;
			System.out.println("异常send-----------------------30行");
			CloseUtil.closeAll(bw);
		}
	}
	//发送数据
	@Override
	public void send(String msg) {
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			isRunnable = false;
			CloseUtil.closeAll(bw);
		}	
	}
	public void sendFile(String message,String filestr) {
		
		File file = new File(filestr);
		send(message+file.getName()+"#"+file.length());
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file),6000000);
			bos = new BufferedOutputStream(client.getOutputStream());
			byte[] files = new byte[3000000];
			int length = 0;
			while((length = bis.read(files))!=-1){
				
				bos.write(files,0,length);
			
			}
			bos.flush();
			System.out.println("文件发送成功！！");
		} catch (IOException e1) {
			
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
	}
}
