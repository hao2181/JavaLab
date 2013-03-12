package com.test.reflect.test;

public class Car {
	
	private String type;
	private String color;
	private int maxSpeed;

	public Car() {
		super();
	}
	
	public Car(String type, String color, int maxSpeed) {
		super();
		this.type = type;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}	
	
	public void introduce(){
		System.out.println("型号："+type+"颜色："+color+"最大时速："+maxSpeed);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
}
