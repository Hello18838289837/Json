package com.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接收使用UDP协议发送来的信息 UDP协议:在使用UDP协议是，没有链接，把数据进行打包后发送，不管接收方是否收到，所以不安全，且传输数据大下为64k
 * 
 * @author Mr.振
 *
 */
public class TestReceive {
	public static void main(String[] args) throws IOException {
		// 创建接收端DatagramSocket对象并设置接收方的端口号
		DatagramSocket ds = new DatagramSocket(8888);
		byte[] bty = new byte[1024];
		int length = bty.length;
		// 接收数据，发送是以包的新式发送，接收也是以包的形式接收
		DatagramPacket dp = new DatagramPacket(bty, length);
		ds.receive(dp);
		// 解析数据
		InetAddress address = dp.getAddress();
		byte[] data = dp.getData();
		int len = dp.getLength();
		// 将解析的字节转为字符串
		String str = new String(data, 0, len);
		// 输出数据
		System.out.println(address.getHostName());
		System.out.println(len);
		System.out.println("发送的数据是:" + str);
		// 释放资源
		ds.close();
	}
}
