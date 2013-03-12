/**
 * 
 */
package com.test.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author zhanghao
 *
 */
public class Client {
	
	
	public void chat(){		
		try {
			Socket socket  = new Socket("127.0.0.1", 5656);
			
			DataInputStream dis  = new DataInputStream(
					socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			while(true){
				String accept = dis.readUTF();
				System.out.println(accept);				
				String send = scanner.nextLine();
				System.out.println("Client"+send);
				dos.writeUTF("Client:"+send);	
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}
