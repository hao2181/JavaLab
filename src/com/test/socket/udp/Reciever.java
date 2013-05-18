package com.test.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciever {
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(3456);
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			while(true){
				ds.receive(dp);//阻塞方法
				String r = new String(dp.getData(),0,dp.getLength(),"UTF-8");
				System.out.println("从"+dp.getAddress()+":"+dp.getPort()+"处获得的数据："+r);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
