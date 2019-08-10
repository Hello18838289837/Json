package com.java.modifylogin;

import java.util.ArrayList;

/**
 * 模拟用户在数据库中存储的信息
 * 
 * @author Mr.振
 *
 */
public class UserDB {
	// 创建一个集合来存放用户信息
	private static ArrayList<User> list = new ArrayList<>();

	// static在程序执行之前就执行，所以集合也要用static修饰
	static {
		User u1 = new User();
		u1.setUsernaem("Admin");
		u1.setPwd("admin");
		list.add(u1);
		User u2 = new User();
		u2.setUsernaem("张三");
		u2.setPwd("123");
		list.add(u2);
		User u3 = new User();
		u3.setUsernaem("李四");
		u3.setPwd("444");
		list.add(u3);
		User u4 = new User();
		u4.setUsernaem("王五");
		u4.setPwd("12345");
		list.add(u4);
	}

	public static ArrayList<User> getUser(){
		return list;
	}
}
