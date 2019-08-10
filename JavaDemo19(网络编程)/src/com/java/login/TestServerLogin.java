package com.java.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  客服端登录的服务端:
 *              A:创建服务端ServerSocket对象
 *              B:监听即等待与客服端连接
 *              C:创建输入流InputStream对象来获取数据
 *              D:输出数据
 *              E:创建输出流OutputStream对象并发送数据
 *              F:释放资源
 *              
 * @author Mr.振
 *
 */
public class TestServerLogin {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10000);
		Socket acp = ss.accept();
		// 获取输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(acp.getInputStream()));
		// 获取用户信息
		String username = br.readLine();
		String pwd = br.readLine();
		// 判断是否正确
		boolean flag = false;
		if ((username.equals("Admin")) && (pwd.equals("admin"))) {
			// 登录成功
			flag = true;
		}
		// 判断flag并返回提示信息
		PrintWriter pw = new PrintWriter(acp.getOutputStream(), true);
		if (flag) {
			pw.println("登录成功!");
		} else {
			pw.println("登陆失败!");
		}
		// 释放资源
		acp.close();
		br.close();
		pw.close();

	}
}
