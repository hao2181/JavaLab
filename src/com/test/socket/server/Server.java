/**
 * 
 */
package com.test.socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhanghao
 *
 */
public class Server {
	
	public void chat(){
		
		try {
			ServerSocket ss = new ServerSocket(5656);
			
			Socket socket = ss.accept();
			
			DataInputStream dis = new DataInputStream(
					socket.getInputStream());
			
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			
			Scanner scanner = new Scanner(System.in);
			
			while(true){
				String accept = dis.readUTF();
				System.out.println(accept);
				
				String send = scanner.nextLine();
				System.out.println("Server:"+send);
				dos.writeUTF("Server:"+send);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
	}

}
