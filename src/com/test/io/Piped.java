/**
 * 
 */
package com.test.io;

import java.io.IOException;
	/**  
	 * ������  
	 * */ 
	public  class Piped{  
	    public static void main(String[] args) throws IOException {  
	        Send send=new Send();  
	        Recive recive=new Recive();  
	        try{  
	        	//�ܵ�����  
	            send.getOut().connect(recive.getInput());  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        new Thread(send).start();  
	        new Thread(recive).start();  
	    }  
	} 


