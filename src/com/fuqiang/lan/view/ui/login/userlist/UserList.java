package com.fuqiang.lan.view.ui.login.userlist;

/**
 * �û��б�
 * @author Administrator
 *
 */
public class UserList {
	public static Object[] obj=new Object[20];
	static int length=0;//����
	static{
		obj[length++]="1607";
		
	}
	
	public static  void add(String name){
		/*
		 * ����
		 */
		if(length==obj.length-1){
			Object[] ob=new Object[obj.length*2];
			for(int i=0;i<length;i++){
				ob[i]=obj[i];
			}
			obj=ob;	
		}
		
		obj[length++]=name;
		
	}
	
	public static void delete(String name){
		if(length<0){
			return;
		}
		int index=0;
		Object[] newobj=new Object[obj.length-1];
		for(int i = 0; i<length;i++){
			if(obj[i].toString().equals(name)){
				continue;
			}
			newobj[index++]=obj[i];
		}
		if(index == length){
			return;
		}
		obj=newobj;
		length--;

	}
	
	public static Object[] getUser(){
		//����һ����ʱ����
		Object[] temp=new Object[length];
		
		for(int i=0;i<temp.length;i++){
			temp[i]=obj[i];
		}
		return temp;
	}
	
}
