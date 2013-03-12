package com.test.socket.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class Sender {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			
			//DatagramPacket dp = new DatagramPacket(buf, length, "localhost", 7777);
			for(int i=0;i<50;i++){
				String dataStr = "世界你好---"+i;
				byte[] data = dataStr.getBytes("UTF-8");
				DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 7777);
				System.out.println("将要发送的数据："+dataStr);
				ds.send(dp);
				Thread.sleep(1000);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
