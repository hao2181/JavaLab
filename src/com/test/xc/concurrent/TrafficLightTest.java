package com.test.xc.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLightTest {

	/**
	 * @param Condition 实现交通灯
	 */
	public static void main(String[] args) {
		final ProcessorTL pt = new ProcessorTL();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					pt.sub1(i);
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<50;i++){
					pt.sub2(i);
				}
				
			}
		}).start();
		
		for (int i = 0; i < 50; i++) {
			pt.sub3(i);
		}

	}

}

class ProcessorTL{
	Lock lock  = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	private int flag = 1;
	public void sub1(int i){
		lock.lock();
		try{
			while (flag!=1) {
				try {
					condition1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("3号灯灭了，1号亮起");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 2;
			condition2.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void sub2(int i){
		lock.lock();
		try {
			while (flag!=2) {
				try {
					condition2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("1号灯灭了，2号亮起");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 3;
			condition3.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void sub3(int i){
		lock.lock();
		try{
		while (flag!=3) {
			try {
				condition3.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("2号灯灭了，3号亮起");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = 1;
		condition1.signal();
		}finally{
			lock.unlock();
		}
	}
	
	
	
}
