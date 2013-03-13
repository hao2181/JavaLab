package com.test.xc.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition 相当于notify wait 但是比这两个组合要强  
 * JDK里有condition实现的阻塞队列可以参考
 * condition 可以有多组condition个子通知各自的　详见ＥＸＡＭＰＬＥ里ThreeCondition....java
 * 
 * @author Administrator
 *
 */
public class ConditionTest {

	public static void main(String[] args) {
		final ProcessorC pc = new ProcessorC();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 50; i++) {
					pc.sub(i);
				}
			}
		}).start();

		for (int i = 0; i < 50; i++) {
			pc.main(i);
		}

	}
}

class ProcessorC {
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	private boolean flag = true;

	public void sub(int i) {
		lock.lock();
		try {
			while (!flag) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("sub thread sequence of " + j + ",loop of "
						+ i);
			}
			flag = false;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while (flag) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("main thread sequence of " + j + ",loop of "
						+ i);
			}
			flag = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

}
