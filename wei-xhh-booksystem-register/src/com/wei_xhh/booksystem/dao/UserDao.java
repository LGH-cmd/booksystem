package com.wei_xhh.booksystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wei_xhh.booksystem.model.User;
import com.wei_xhh.booksystem.util.JdbcUtil;
/**
 * userDao
 * @author 温心雨i
 *
 */
public class UserDao {
	//注册
	public void register(User user) throws Exception {
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//插入用户数据
		String sql = "insert into t_user(username, password, email, gender) values(?,?,?,?)";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, user.getUsername());
		prps.setString(2, user.getPassword());
		prps.setString(3, user.getEmail());
		prps.setString(4, user.getGender());
		
		prps.execute();
		
		//关闭连接
		conn.close();
	}
	//根据username查找
	public boolean checkName(String userName) throws Exception {
		
		Connection conn = JdbcUtil.getConnection();
		//查询是否有名字为userName这个数据
		String sql = "select * from t_user where username=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, userName);
		
		ResultSet set = prps.executeQuery();
		if(set.next()) {
			//用户名重复了
			return false;
		}
		//没有重复
		return true;
	}
	//登录，账号密码正确
	public User login(String username, String password) throws Exception {
		
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "select * from t_user where username=? and password=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, username);
		prps.setString(2, password);
		
		ResultSet set = prps.executeQuery();
		
		if(set.next()){
			//说明登录成功，封装查询结果到User对象中，并返回对象
			User u = new User();
			//获取查询到的一行数据中的每一列的值
			int id = set.getInt("id");
			String name = set.getString("username");
			String pwd = set.getString("password");
			String email = set.getString("email");
			String gender = set.getString("gender");
			//设置查询结果到user对象中
			u.setId(id);
			u.setUsername(name);
			u.setPassword(pwd); 
			u.setEmail(email);
			u.setGender(gender);
			//返回对象
			return u;
		}
		//查询不到数据，返回null
		return null;
	}
	
}
