package com.test.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static Car initCarParameter() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		
		Class clazz = Car.class;
		//Class clazz1 = Class.forName("com.test.reflection.test.Car");
		Constructor cars  = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car)cars.newInstance();
		
		Method setType = clazz.getDeclaredMethod("setType", String.class) ;
		setType.invoke(car, "A388");
		
		Method setColor = clazz.getDeclaredMethod("setColor", String.class);
		setType.invoke(car, "黑色");
		
		Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed", Integer.class);
		setMaxSpeed.invoke(car, 200);
		return car;
	}
}
