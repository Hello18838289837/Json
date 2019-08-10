package com.java.mytcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 需求:使用TCP协议来发送数据，接收端接收并将数据转为大写在返回给发送端
 * 
 * 客服端:发送数据
 * 服务端:接收数据
 * 服务端:转换数据
 * 服务端:发出转换数据
 * 客服端:接收转换的数据
 * @author Mr.振
 *
 */
public class TestMyTcpSend {
	public static void main(String[] args) throws IOException {
		// 创建客服端Socket对象,并建立连接，需要ip和端口好
		InetAddress byName = InetAddress.getByName("DESKTOP-PREST42");
		int port =10000;
		Socket sk = new Socket(byName,port);
		//创建输出流OutputStream对象
		OutputStream ops = sk.getOutputStream();
		//创建发送信息，并发送
		String s = "你好吗?我很好！ Are you ok? yes I am ok!";
		byte[] bty = s.getBytes();
		ops.write(bty);
		//接收服务端传回来的数据,创建输入流对象
		InputStream is = sk.getInputStream();
		//接收数据
		byte[] b = new byte[1024];
		int len;
		len=is.read(b);
		String str = new String(b,0,len);
		System.out.println("接收返回的数据；"+str);
		System.out.println("客户端主机名："+sk.getLocalAddress());
		System.out.println("客户端端口号:"+sk.getPort());
		//释放资源
		sk.close();
		ops.close();
		
	}
}
