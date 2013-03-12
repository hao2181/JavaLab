package com.test.xc;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		AAAAA a = new AAAAA();
		Test5A t5 = new Test5A(a);
		t5.start();
	
	//	AAAAA a1 = new AAAAA();
		Thread.sleep(1);
			a.methodB();
		}
}
