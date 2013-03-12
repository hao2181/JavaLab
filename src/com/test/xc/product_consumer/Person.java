package com.test.xc.product_consumer;

import java.util.concurrent.CountDownLatch;

/**
 * 人员类
 * @author ZhangHao
 * @date  2012-7-31
 */
public class Person extends Thread {
	private Room r ;
	private CountDownLatch cdl;
	public Person(String name,Room r,CountDownLatch cdl){
		super(name);
		this.r = r;
		this.cdl = cdl;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		System.out.println(getName()+"说：冲啊！开饭了！");
		r.enter();
		cdl.countDown();
	}
}
