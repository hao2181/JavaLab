package com.test.concurrent;

import java.util.concurrent.ThreadFactory;


public class TestThreadFactory implements ThreadFactory {

	    public Thread newThread(Runnable r) {

	        Thread thread = new Thread(r);

	        thread.setDaemon(false);

	        return thread;

	    }
	    
	    public static void main(String[] args) {
	    	TestThreadFactory t = new TestThreadFactory();
	    	Thread t1 = t.newThread(new Runnable() {
				public void run() {
					System.out.println("fuck");
				}
			});
	    	t1.start();
		}
}
