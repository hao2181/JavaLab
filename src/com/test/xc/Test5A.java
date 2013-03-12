package com.test.xc;

public class Test5A extends Thread{
	private AAAAA a ;
	public Test5A(AAAAA a){
		this.a = a;
	}
	@Override
	public void run() {
		a.methodA();
	}


}
