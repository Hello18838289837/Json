package com.java.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收使用TCP协议发送的数据 
 *                 分析: A:创建ServerSocket接收端的对象 
 *                      B:监听是否有建立连接
 *                      C:获取输入流
 *                      D:解析输入流中的信息
 *                      E:输出接收的信息
 * 
 * @author Mr.振
 *
 */
public class TestReceiveTCP {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 创建ServerSocket接收端的对象
		int port = 10001;
		ServerSocket ss = new ServerSocket(port);
		// 监听看是否有建立链接
		Socket accept = ss.accept();
		// 获取输入流对象
		InputStream is = accept.getInputStream();
		// 获取数据使用每次读取为一个字符数组的方法
		byte[] bty = new byte[1024];
		// 定义储存每次读取的长度
		int len;
		len = is.read(bty);
		// 将len转为字符串
		String str = new String(bty, 0, len);
		// 输出解析的数据
		InetAddress address = accept.getInetAddress();
		System.out.println("端口号是：" + accept.getLocalPort());
		System.out.println("接收的信息是:" + str);
		System.out.println("发送的主机名:" + address.getHostName());
		System.out.println("接收的数据长度是:" + len);
		// 释放资源
		accept.close();
		is.close();
	}
}
