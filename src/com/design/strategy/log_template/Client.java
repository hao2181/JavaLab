package com.design.strategy.log_template;

public class Client {

	/**
	 * 策略模式加入模板模式 的组合 
	 */
	public static void main(String[] args) {
		LogContext ctx = new LogContext();
		ctx.log("mess"); 
		ctx.log("message2");
	}

}
