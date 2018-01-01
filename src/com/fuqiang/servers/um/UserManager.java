package com.fuqiang.servers.um;

import com.fuqiang.servers.entity.User;
import com.fuqiang.servers.ud.UserDao;

public class UserManager {


	
	/**
	 * 添加用户
	 */
	public static boolean addUser(User user){
		if(UserDao.map.containsValue(user)){
			return false;
		}
		UserDao.map.put(user.getUserName(), user);
		return true;
	}
	
	/**
	 * 删除用户
	 */
	public static void delectUser(){
		
		
		
	}
	
	/**
	 * 修改用户
	 */
	public static void updateUser(User user){
		
		
 	}
	
	
	//查看单个用户
	public static User querySingUser(String name){
		User user = UserDao.map.get(name);
		return user;
	}
	

	public static void queryUser(){
		
	}
	
}
