/**
 * 
 */
package com.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhanghao
 *
 */
public class ProxyFactory {

	public static Object getProxyObject(Object obj) throws Exception{
		
		InvocationHandler handler = new DynamicProxy(obj);
		
		Class<?> ProxyClass = Proxy.getProxyClass(obj.getClass().getClassLoader(), obj.getClass().getInterfaces());
		//Class<?> classType = handler.getClass();
		
		System.out.println(ProxyClass.getName());
		System.out.println(ProxyClass.getClassLoader());
		
		Object object = ProxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler});
		//Object object = Proxy.newProxyInstance(classType.getClassLoader(), 
				//obj.getClass().getInterfaces(), handler);
		
		return object;
	}
}
