/**
 * 
 */
package com.test.socket.client;

import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.net.Socket;  
import java.util.Scanner;  
  
/** 
 * ע���õ������������DataInputStream��DataOutputStream���ɶԳ��֣�������ֽ��� 
 */  
// �ͻ�����  
public class ChatClient {  
    private String host = "192.168.3.6";// Ĭ�����ӵ�����  
    private int port = 1125;// Ĭ�����ӵ��˿�8189  
  
    public ChatClient() {  
  
    }  
  
    // ���ӵ�ָ��������Ͷ˿�  
    public ChatClient(String host, int port) {  
        this.host = host;  
        this.port = port;  
    }  
  
    public void chat() {  
        try {  
            // ���ӵ�������  
            Socket socket = new Socket(host, port);
  
            try {  
                // ��ȡ�������˴�������Ϣ��DataInputStream  
                DataInputStream in = new DataInputStream(socket  
                        .getInputStream());  
                // ��������˷�����Ϣ��DataOutputStream  
                DataOutputStream out = new DataOutputStream(socket  
                        .getOutputStream());  
  
                // װ�α�׼�����������ڴӿ���̨����  
                Scanner scanner = new Scanner(System.in);  
  
                while (true) {  
                    String send = scanner.nextLine();  
                    System.out.println("�ͻ��ˣ�" + send);  
                    // �Ѵӿ���̨�õ�����Ϣ���͸������  
                    out.writeUTF("�ͻ��ˣ�" + send);  
                    // ��ȡ���Է���������Ϣ  
                    String accpet = in.readUTF();  
                    System.out.println(accpet);  
                }  
  
            } finally {  
                socket.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) {  
        new ChatClient().chat();  
    }  
}  