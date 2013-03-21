/**
 * 
 */
package com.design.proxy;

import java.util.Collection;

/**
 * @author ZhangHao
 * @date 2013-3-21
 * 代理模式是通过创建一个代理对象，用这个代理对象去代表真实的对象，客户端得到这个代理对象过后，对客户端没有什么影响，就跟得到了真实对象一样来使用。
 * 当客户端操作这个代理对象的时候，实际上功能最终还是会由真实的对象来完成，只不过是通过代理操作的，也就是客户端操作代理，代理操作真正的对象。
 * 正是因为有代理对象夹在客户端和被代理的真实对象中间，相当于一个中转，那么在中转的时候就有很多花招可以玩，比如：判断一下权限，如果没有足够的权限那就不给你中转了，等等。
 */
public class Client {
	public static void main(String[] args) throws Exception {
		UserManager userManager = new UserManager();
		Collection<UserModelApi> col = userManager.getUserByDepId("0101");

		// 如果只是显示用户名称，那么不需要重新查询数据库
		for (UserModelApi umApi : col) {
			System.out.println("用户编号：=" + umApi.getUserId() + ",用户姓名：="
					+ umApi.getName());
		}
		// 如果访问非用户编号和用户姓名外的属性，那就会重新查询数据库
		for (UserModelApi umApi : col) {
			System.out.println("用户编号：=" + umApi.getUserId() + ",用户姓名：="
					+ umApi.getName() + ",所属部门：=" + umApi.getDepId());
		}
	}
}