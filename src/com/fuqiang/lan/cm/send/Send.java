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
	//�ܵ������
	private BufferedWriter bw;
	
	private static boolean isRunnable = true;
	//��������ʼ��

	public Send(Socket client) {
		this.client=client;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			isRunnable = false;
			System.out.println("�쳣send-----------------------30��");
			CloseUtil.closeAll(bw);
		}
	}
	//��������
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
			System.out.println("�ļ����ͳɹ�����");
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
