/**
 * 
 */
package com.design.prototype.javaclone;

/**
 * @author ZhangHao
 * @date 2013-3-21
 */
public class Client {
	public static void main(String[] args) {
		// 先创建原型实例
		PersonalOrder oa1 = new PersonalOrder();
		// 设置原型实例的订单数量的值
		oa1.setOrderProductNum(100);
		System.out.println("这是第一次获取的对象实例===" + oa1.getOrderProductNum());
		// 通过克隆来获取新的实例
		PersonalOrder oa2 = (PersonalOrder) oa1.clone();
		oa2.setOrderProductNum(80);
		System.out.println("输出克隆出来的实例===" + oa2.getOrderProductNum());
		// 再次输出原型实例的值
		System.out.println("再次输出原型实例===" + oa1.getOrderProductNum());
	}
}