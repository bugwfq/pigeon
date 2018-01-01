package com.fuqiang.servers.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
	public static Properties p = new Properties(); 
	static{
		try {
			p.load(new FileInputStream(new File("src/com/fuqiang/servers/configuration/configuration.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void fulsh(){
		try {
			p.store(new FileOutputStream(new File("src/com/fuqiang/servers/configuration/configuration.properties")), "comments");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
