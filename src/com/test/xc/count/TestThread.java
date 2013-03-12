package com.test.xc.count;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestThread extends Thread{

	public static int num = 0;
	private CountDownLatch cdl;
	public TestThread(CountDownLatch cdl){
		this.cdl = cdl;
	}
	public TestThread(){
	}
	public synchronized void add(){
		num ++;
	}
	
	@Override
	public void run() {
		boolean s = new Random().nextBoolean();
		//System.out.println(s);
		if(s){
			add();
		}else{
			
		}
		cdl.countDown();
	}
}
