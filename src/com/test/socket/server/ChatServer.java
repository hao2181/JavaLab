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
 * ģ��qq���칦�ܣ� ʵ�ֿͻ������������һ��һ�������칦�ܣ��ͻ������ȷ������죬����������ڷ������˺Ϳͻ�����ʾ�� 
 * Ȼ���������Ҳ����������Ϣ��ͬ����ϢҲ�ڿͻ��˺ͷ���������ʾ 
 */  
  
// ��������  
public class ChatServer {  
    private int port = 8189;// Ĭ�Ϸ������˿�  
  
    public ChatServer() { 
    	
    }  
  
    // ����ָ���˿ڵķ�����  
    public ChatServer(int port) {  
        this.port = port;  
    }  
  
    // �ṩ����  
    public void service() {  
        try {// ��������������  
            ServerSocket server = new ServerSocket(port);  
            // �ȴ�ͻ�����  
            Socket socket = server.accept();  
            try {  
                // ��ȡ�ͻ��˴�������Ϣ��DataInputStream  
                DataInputStream in = new DataInputStream(socket  
                        .getInputStream());  
                // ��ͻ��˷�����Ϣ��DataOutputStream  
                DataOutputStream out = new DataOutputStream(socket  
                        .getOutputStream());  
                // ��ȡ����̨�����Scanner  
                Scanner scanner = new Scanner(System.in);  
                while (true) {  
                    // ��ȡ���Կͻ��˵���Ϣ  
                    String accpet = in.readUTF();  
                    System.out.println(accpet);  
                    String send = scanner.nextLine();  
                    System.out.println("��������" + send);  
                    // �ѷ������˵����뷢��ͻ���  
                    out.writeUTF("��������" + send);  
                }  
            } finally {// ��������ʧ�ܵĻ�����ִ��socket.close();  
                socket.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) {  
        new ChatServer().service();  
    }  
} 