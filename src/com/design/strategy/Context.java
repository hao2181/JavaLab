package com.design.strategy;

public class Context {
	
	private Strategy strategy;
	
	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public double calculate(double price){
		return this.strategy.calPrice(price);
	}

}
