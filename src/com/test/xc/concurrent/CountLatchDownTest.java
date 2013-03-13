package com.test.xc.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 计数器倒计时
 * @author Administrator
 *
 */
public class CountLatchDownTest {
	
	public static void main(String[] args) {
	
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch work = new CountDownLatch(5);
		System.out.println("主线程开启，创建分支线程并且运行");
		for(int i = 0;i<5;i++){
			new Thread(new ProcessorCDL(start, work)).start();
		}
		System.out.println("主线程" + Thread.currentThread().getName()
				+ "开始倒计时5个数");
		start.countDown();
		try {
			work.await();
			System.out.println("所有线程运行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ProcessorCDL implements Runnable{
	 CountDownLatch start = null;
	 CountDownLatch work = null;
	 public ProcessorCDL(CountDownLatch start ,CountDownLatch work) {
		this.start = start;
		this.work = work;
	}
	 
	@Override
	public void run() {
		try {
			start.await();
			dowork();
			System.out.println(Thread.currentThread().getName()+"分支运行完毕");
			work.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	void dowork(){
		System.out.println(Thread.currentThread().getName()+"开始运行dowork");
		try {
			Thread.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}