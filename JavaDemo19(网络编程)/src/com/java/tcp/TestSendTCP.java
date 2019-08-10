package com.java.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *   使用TCP协议来发送信息：使用的类是Socket
 *      分析:
 *         A:创建Socket对象
 *         B:获取输出流
 *         C:发送数据
 *         D:释放资源
 * @author Mr.振
 *
 */
public class TestSendTCP {
	public static void main(String[] args) throws IOException {
		// A:创建Socket对象
		InetAddress name = InetAddress.getByName("DESKTOP-PREST42");
		int port = 10001;
		Socket sk = new Socket(name, port);
		// B:获取输出流OutputStream对象
		OutputStream ops = sk.getOutputStream();
		// C:定义发送的内容,并通过IO流进行输出
		String s = "Hello TCP,you are also a lucky dog!";
		byte[] bty = s.getBytes();
		ops.write(bty);
		// D:释放资源
		ops.close();
		sk.close();
	}
}
