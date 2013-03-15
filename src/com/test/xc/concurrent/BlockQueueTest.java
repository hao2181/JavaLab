package com.test.xc.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 2个blockqueu组合完成交替执行　ｐｕｔ　队列慢时阻塞　　　ｔａｋｅ　队列空时阻塞
 * @author zhanghao
 *
 */
public class BlockQueueTest {

	public static void main(String[] args) {
		final BlockingQueue<String> queue1 = new ArrayBlockingQueue<String>(1);
		final BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(1);
		{
			try {
				queue1.put("aaa");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		new Thread (new Runnable() {
			@Override
			public void run() {
				while (true) {
				try {
					queue1.put("aaa");
					for (int i = 0; i < 50; i++) {
						System.out.println(Thread.currentThread().getName()+"====="+i);
					}
					queue2.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
		}).start();
		
		
		new Thread (new Runnable() {
			@Override
			public void run() {
				while (true) {
				try {
					queue2.put("aaa");
					for (int i = 0; i < 50; i++) {
						System.out.println(Thread.currentThread().getName()+"====="+i);
					}
					queue1.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}).start();
		
	}
}


