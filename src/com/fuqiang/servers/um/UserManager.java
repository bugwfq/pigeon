package com.fuqiang.servers.um;

import com.fuqiang.servers.entity.User;
import com.fuqiang.servers.ud.UserDao;

public class UserManager {


	
	/**
	 * ����û�
	 */
	public static boolean addUser(User user){
		if(UserDao.map.containsValue(user)){
			return false;
		}
		UserDao.map.put(user.getUserName(), user);
		return true;
	}
	
	/**
	 * ɾ���û�
	 */
	public static void delectUser(){
		
		
		
	}
	
	/**
	 * �޸��û�
	 */
	public static void updateUser(User user){
		
		
 	}
	
	
	//�鿴�����û�
	public static User querySingUser(String name){
		User user = UserDao.map.get(name);
		return user;
	}
	

	public static void queryUser(){
		
	}
	
}
