package com.test.xc.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	final CyclicBarrier cb = new CyclicBarrier(3);
	
	/**
	 * @param 循环栏删 设置为3 就是三个线程在同一个cyclicbarrier上调用await的次数必须达到 3次否者一直等待
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrierTest cbt = new CyclicBarrierTest();
		cbt.test1();
	}
	
	public void test1() throws InterruptedException{
		new Thread(new ProcessorCB(cb)).start();
		Thread.sleep(5000);
		new Thread(new ProcessorCB(cb)).start();
		Thread.sleep(5000);
		new Thread(new ProcessorCB(cb)).start();
	}
}

class ProcessorCB implements Runnable{
	CyclicBarrier cb = null;
	public ProcessorCB(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"来了");
		try {
			System.out.println(cb.await());
			System.out.println("输出完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}