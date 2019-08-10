package com.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP协议来发送信息: A:在UDP中使用DatagramSocket这个类来接收和发送
 * 
 * @author Mr.振
 *
 */
public class TestUDP {
	public static void main(String[] args) throws IOException {
		UDPSend();
	}

	//使用UDP协议来发送信息
	private static void UDPSend() throws  IOException {
		// 创建发送端DatagramSocket对象
		DatagramSocket ds = new DatagramSocket();
		//创建发送数据并打包
		String str = "Hello UDP,You are a lucky dog!";
		byte[] bty = str.getBytes();
		int len = bty.length;
		InetAddress name = InetAddress.getByName("DESKTOP-PREST42");
		int port = 8888;
		DatagramPacket dp = new DatagramPacket(bty, len,name ,port );
		//发送数据
		ds.send(dp);
		//释放资源
		ds.close();
	}
	
}
