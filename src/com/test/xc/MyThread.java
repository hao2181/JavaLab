package com.test.xc;

public class MyThread extends Thread {

	public void run(){
		
		for(int i= 0;i<1000;i++){
			System.out.println("thread:---"+i);
		}
	}
	
	public static void main(String[] args) {
		MyThread m = new MyThread();
		m.start();

		for(int i= 0;i<1000;i++){
			System.out.println("main:----------------------------"+i);
		}
	}
}
