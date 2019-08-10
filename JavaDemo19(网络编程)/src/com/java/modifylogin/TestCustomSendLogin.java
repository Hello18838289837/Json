package com.java.modifylogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 用户登录客服端:
 *          A:使用TCP协议登录首先要创建一个客服端发送对象Socket(端口号,接收方地址)
 *          B:创建输出流OutputStream对象，并发送数据
 *          C:接收服务端返回的判断数据，
 *          D:输出返回的信息
 *          E:释放资源
 * 
 * @author Mr.振
 * 创建输出流,应每次读取一行数据可以使用高效流
		// OutputStream ops = sk.getOutputStream();
		// OutputStreamWriter osw = new OutputStreamWriter(ops);
		// BufferedWriter bw = new BufferedWriter(osw);
		// BufferedWriter bw = new BufferedWriter(new
		// OutputStreamWriter(sk.getOutputStream()));
 */
public class TestCustomSendLogin {
	public static void main(String[] args) throws IOException {
		// 创建Socket
		Socket sk = new Socket(InetAddress.getByName("DESKTOP-PREST42"), 10000);
		// 创建输出流使用IO流的高效性对象BufferedReader来获取账号和密码
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("请输入账号:");
		String username = br.readLine();
		System.out.println("请输入密码:");
		String pwd = br.readLine();

		// 也可以使用打印流
		PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
		pw.println(username);
		pw.println(pwd);
		// 获取登录返回的信息
		BufferedReader reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		String result = reader.readLine();
		System.out.println(result);
		// 释放资源
		sk.close();

	}
}
