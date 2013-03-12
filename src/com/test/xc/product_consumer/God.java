package com.test.xc.product_consumer;

import java.util.concurrent.CountDownLatch;

public class God {

	public static void main(String[] args) {
		Room r = new Room();
		int threadNum = 20;
		//线程计数器
		CountDownLatch cdl = new CountDownLatch(threadNum);
		Person p = new Person("厨师小强",r,cdl);
		p.start();
		
		for(int i=0 ; i<threadNum;i++){
			new Person("顾客"+i,r,cdl).start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("所有人吃完饭了 厨师可以下班了！@！@#￥@##……&%*&*");
		r.setFinished(true);
	}
}
