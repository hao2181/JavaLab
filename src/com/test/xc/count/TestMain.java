package com.test.xc.count;

import java.util.concurrent.CountDownLatch;


public class TestMain  {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(100);
		
		for(int i=0;i<100;i++){
			new TestThread(cdl).start();
			//new TestThread().start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(TestThread.num);
		
	}
}
