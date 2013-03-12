package com.design.strategy.log;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogContext ctx = new LogContext();
		ctx.log("mess"); 
		ctx.log("message2");
	}

}
