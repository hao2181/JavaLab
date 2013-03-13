package com.test.xc.concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		Exchanger<String> ex = new Exchanger<String>();
		new Thread(new ProcessorET("zhang", ex)).start();
		new Thread(new ProcessorET("hao", ex)).start();
	}
}

class ProcessorET implements Runnable {
	String msg = null;
	Exchanger<String> ex = null;

	public ProcessorET(String msg, Exchanger<String> ex) {
		this.msg = msg;
		this.ex = ex;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "的数据" + msg);
			Thread.sleep((long) (Math.random() * 10000));
			String data = ex.exchange(msg);
			System.out.println(Thread.currentThread().getName() + "换回的数据"
					+ data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
