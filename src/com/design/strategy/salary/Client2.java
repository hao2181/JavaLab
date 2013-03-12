package com.design.strategy.salary;

public class Client2 {
	public static void main(String[] args) {
		// 测试新添加的支付方式
		PaymentStrategy strategyCard2 = new Card2("010998877656");
		PaymentContext ctx4 = new PaymentContext("小张", 9000, strategyCard2);
		ctx4.payNow();
	}
}
