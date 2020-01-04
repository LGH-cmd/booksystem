package com.iteima.system.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 连接数据库工具类
 * @author 温心雨i
 *
 */
public class JdbcUtil {

	public static Connection getConnection() throws Exception {
		
		//注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//获取连接
		String url = "jdbc:mysql://localhost:3306/booksystem?serverTimezone=UTC&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "025431");
		
		return conn;
	}
}
