package com.fuqiang.servers.ud;

import java.util.HashMap;

import com.fuqiang.servers.entity.User;

public class UserDao {
	public static HashMap<String,User> map = new HashMap<>();
	static{
		DomUserList.load();
	}
}
