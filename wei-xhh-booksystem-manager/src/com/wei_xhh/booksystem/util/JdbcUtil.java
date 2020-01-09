package com.wei_xhh.booksystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	
	public static Connection getConnection() throws Exception {
		
		//注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//创建连接
		String url = "jdbc:mysql://localhost:3306/booksystem?serverTimezone=UTC&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "025431");
		
		return conn;
	}
}
