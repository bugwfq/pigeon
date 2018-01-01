package com.fuqiang.servers.sm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.Socket;

public class SentFile{
	byte[] byteBuffer =new byte[1024];
	RandomAccessFile randomFile;
	InputStream is;
	public SentFile(Socket s){
		try {
			randomFile=new RandomAccessFile("","r");
			is=s.getInputStream();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
}
