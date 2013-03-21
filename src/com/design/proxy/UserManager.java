package com.design.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 实现示例要求的功能
 */
public class UserManager {
	/**
	 * 根据部门编号来获取该部门下的所有人员
	 * 
	 * @param depId
	 *            部门编号
	 * @return 该部门下的所有人员
	 */
	public Collection<UserModelApi> getUserByDepId(String depId)
			throws Exception {
		Collection<UserModelApi> col = new ArrayList<UserModelApi>();
		Connection conn = null;
		try {
			conn = this.getConnection();
			// 只需要查询userId和name两个值就可以了
			String sql = "select u.userId,u.name "
					+ "from tbl_user u,tbl_dep d "
					+ "where u.depId=d.depId and d.depId like ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, depId + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 这里是创建的代理对象，而不是直接创建UserModel的对象
				Proxy proxy = new Proxy(new UserModel());
				// 只是设置userId和name两个值就可以了
				proxy.setUserId(rs.getString("userId"));
				proxy.setName(rs.getString("name"));

				col.add(proxy);
			}

			rs.close();
			pstmt.close();
		} finally {
			conn.close();
		}
		return col;
	}

	private Connection getConnection() throws Exception {
		Class.forName("你用的数据库对应的JDBC驱动类");
		return DriverManager.getConnection("连接数据库的URL", "用户名", "密码");
	}
}