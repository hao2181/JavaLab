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
public class Client {
	
	public static void main(String[] args) throws Exception {
		
		RealSubject rs = new RealSubject();
		
		Subject subject = (Subject)ProxyFactory.getProxyObject(rs);
		
		subject.echo();
		
	}
}
