package com.wei_xhh.booksystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	
	public static Connection getConnection() throws Exception {
		
		//ע������
		Class.forName("com.mysql.cj.jdbc.Driver");
		//��������
		String url = "jdbc:mysql://localhost:3306/booksystem?serverTimezone=UTC&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "025431");
		
		return conn;
	}
}
