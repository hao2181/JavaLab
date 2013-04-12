/**
 * 
 */
package com.test.socket.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Vector;

import antlr.CharBuffer;

/**
 * @author ZhangHao 
 * @date  2013-4-12
 */
public class ServerHandler implements Runnable {
	
	private Socket socket = null;
	private Vector<Socket> vector = null;
	private String msg = null;
	BufferedReader reader = null;
	PrintWriter writer = null;
	public ServerHandler() {
		
	}	
	
	public ServerHandler(Socket socket, Vector vector) {
		this.socket = socket;
		this.vector = vector;
	}

	@Override
	public void run() {
		try {
			System.out.println(socket.getInetAddress()+"="+socket.getPort()+"连接到服务器！");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((msg=reader.readLine())!=null){
				System.out.println(msg);
				//writer.println("服务器"+new Date()+"收到消息："+msg);
				for(int i=0;i<vector.size();i++){
					writer = new PrintWriter(vector.get(i).getOutputStream());
					writer.println(socket.getInetAddress()+"="+socket.getPort()+"说:"+msg);
					writer.flush();
				}
				//writer.flush();
                if (msg.equals("bye")) {
                    break;  
                } 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket!=null){
				try {
					socket.close();
					reader.close();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
