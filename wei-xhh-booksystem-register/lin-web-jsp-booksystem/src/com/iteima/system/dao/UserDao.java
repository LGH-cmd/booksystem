package com.iteima.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iteima.system.model.User;
import com.iteima.system.util.JdbcUtil;

/**
 * jdbc操作完成用户注册功能
 * @author 温心雨i
 *
 */
public class UserDao {
	
	//注册
	public void register(User user) throws Exception {
		
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "insert into t_user(username, password, email, gender) values(?,?,?,?)";
		PreparedStatement prps = conn.prepareStatement(sql);
		
		prps.setString(1, user.getUsername());
		prps.setString(2, user.getPassword());
		prps.setString(3, user.getEmail());
		prps.setString(4, user.getGender());
		
		prps.execute();
		
		conn.close();
	}
	
	//用户名重复校验
	public boolean checkName(String username) throws Exception {
		
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//获得执行者对象
		String sql = "select * from t_user where username=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		//设置参数
		prps.setString(1,username);
		//发起查询，返回结果集
		ResultSet set = prps.executeQuery();
		//判断结果集中是否有数据，有表示用户名存在
		//next()返回true表示查到了数据
		if(set.next()){
			//用户名重复了，不能注册
			return false;
		}
		return true;

	}
	
	//用户登录
	public User login(String username, String password) throws Exception {
		
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "select * from t_user where username=? and password=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		
		prps.setString(1, username);
		prps.setString(2, password);
		
		ResultSet set = prps.executeQuery();
		
		if(set.next()) {
			
			User user = new User();
			int id = set.getInt("id");
			String name = set.getString("username");
			String pwd = set.getString("password");
			String email = set.getString("email");
			String gender = set.getString("gender");
			
			user.setId(id);
			user.setUsername(name);
			user.setPassword(pwd); 
			user.setEmail(email);
			user.setGender(gender);

			return user;
		}
		
		return null;
	}
	
}
