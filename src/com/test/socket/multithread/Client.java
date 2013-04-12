/**
 * 
 */
package com.test.socket.multithread;

import java.io.*;
import java.net.*;

public class Client {
	
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	String msg = null;
	public Client() {
		try {
				socket = new Socket("192.168.3.6", 1255);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		        while (true) {  
		            String msg = reader.readLine();  
		            out.println(msg);  
		            out.flush();  
		            if (msg.equals("bye")) {  
		                break;  
		            }  
		            System.out.println(in.readLine());  
		        }  
		}catch (IOException e) {
			
		}finally{
			out.close();
			try {
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
