package com.fuqiang.lan.cm.tools;

import com.fuqiang.lan.view.ui.login.userlist.UserList;

public class ReceiveTools {
	public static boolean returnLogin(String request){
		if(request==null){
			return false;
		}
		if(request.contains("true")){
			return true;
		}else{
			return false;
		}
	}
	public static boolean returnUserList(String request){
		if(request.startsWith("@userList#")){
			if(request.startsWith("@userList#")){
    			String u = request.split("#")[1];
    			String[]  us =  u.split(",");
    			for (String string : us) {
    				UserList.add(string);
    				System.out.println(string);
    			}
    		}
			return true;
		}
		return false;
		
	}
}
