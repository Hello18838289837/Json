package com.java.mytcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端:接收数据并转换数据后返回客服端
 * 
 * @author Mr.振
 *
 */
public class TestMyTcpServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//创建服务端对象ServerSocket
		int port = 10000;
		ServerSocket  ss = new ServerSocket(port);
		//监听链接
		Socket apt = ss.accept();
		//创建输入流InputStream对象
		InputStream is = apt.getInputStream();
		//获取数据
		byte[] bty = new byte[1024];
		//定义每次储存读取的长度变量
		int len;
		len=is.read(bty);
		//将字节数组转为字符串
		String str = new String(bty,0,len);
		System.out.println("服务端接收的数据:"+str);
		System.out.println("服务端口号:"+apt.getLocalPort());
		System.out.println("服务端主机名:"+apt.getInetAddress().getHostName());
		//进行数据的转换，把小写转为大写，或把大写改为小写
		//String lowerCase = str.toLowerCase();
		String lowerCase = str.toUpperCase();
		//通过监听链接对象来获取输出流对象
		OutputStream os = apt.getOutputStream();
		//将转换后的数据转为字节数组
		byte[] bs = lowerCase.getBytes();
		os.write(bs);
		//释放资源
		apt.close();
		is.close();
		os.close();
		
	}
}
