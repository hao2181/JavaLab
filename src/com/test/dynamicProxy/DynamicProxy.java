/**
 * 
 */
package com.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhanghao
 *
 */
public class DynamicProxy implements InvocationHandler {
	
	private Object sub ;
	
	public DynamicProxy(Object obj){
		this.sub = obj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("-------------------Bfore------------------");
		method.invoke(sub, args);		
		System.out.println("-------------------After------------------");
		return null;
	}
	
	

}
