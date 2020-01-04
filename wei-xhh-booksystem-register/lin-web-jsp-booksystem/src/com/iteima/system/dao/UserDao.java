package com.iteima.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iteima.system.model.User;
import com.iteima.system.util.JdbcUtil;

/**
 * jdbc��������û�ע�Ṧ��
 * @author ������i
 *
 */
public class UserDao {
	
	//ע��
	public void register(User user) throws Exception {
		
		//��ȡ����
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
	
	//�û����ظ�У��
	public boolean checkName(String username) throws Exception {
		
		//��ȡ����
		Connection conn = JdbcUtil.getConnection();
		//���ִ���߶���
		String sql = "select * from t_user where username=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		//���ò���
		prps.setString(1,username);
		//�����ѯ�����ؽ����
		ResultSet set = prps.executeQuery();
		//�жϽ�������Ƿ������ݣ��б�ʾ�û�������
		//next()����true��ʾ�鵽������
		if(set.next()){
			//�û����ظ��ˣ�����ע��
			return false;
		}
		return true;

	}
	
	//�û���¼
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
