package com.design.strategy;

public class StrategyA implements Strategy {

	@Override
	public double calPrice(double price) {
		
		return price*0.8;
	}
	

	
}
