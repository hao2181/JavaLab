package com.design.strategy;

public class Client {

	/**
	 * 策略模式的核心内容是将各种算法抽象出来形成独立的算法类
	 * 因此多个if-else语句可以考虑使用策略模式
	 */
	public static void main(String[] args) {
		
		Strategy strategyA = new StrategyA();
		
		Context context = new Context(strategyA);
		
		double  price = context.calculate(100);
		
		System.out.println("客户报价："+price);
	}

}
