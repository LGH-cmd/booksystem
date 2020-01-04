package com.wei_xhh.booksystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wei_xhh.booksystem.model.User;
import com.wei_xhh.booksystem.util.JdbcUtil;
/**
 * userDao
 * @author ������i
 *
 */
public class UserDao {
	//ע��
	public void register(User user) throws Exception {
		//��ȡ����
		Connection conn = JdbcUtil.getConnection();
		//�����û�����
		String sql = "insert into t_user(username, password, email, gender) values(?,?,?,?)";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, user.getUsername());
		prps.setString(2, user.getPassword());
		prps.setString(3, user.getEmail());
		prps.setString(4, user.getGender());
		
		prps.execute();
		
		//�ر�����
		conn.close();
	}
	//����username����
	public boolean checkName(String userName) throws Exception {
		
		Connection conn = JdbcUtil.getConnection();
		//��ѯ�Ƿ�������ΪuserName�������
		String sql = "select * from t_user where username=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, userName);
		
		ResultSet set = prps.executeQuery();
		if(set.next()) {
			//�û����ظ���
			return false;
		}
		//û���ظ�
		return true;
	}
	//��¼���˺�������ȷ
	public User login(String username, String password) throws Exception {
		
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "select * from t_user where username=? and password=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, username);
		prps.setString(2, password);
		
		ResultSet set = prps.executeQuery();
		
		if(set.next()){
			//˵����¼�ɹ�����װ��ѯ�����User�����У������ض���
			User u = new User();
			//��ȡ��ѯ����һ�������е�ÿһ�е�ֵ
			int id = set.getInt("id");
			String name = set.getString("username");
			String pwd = set.getString("password");
			String email = set.getString("email");
			String gender = set.getString("gender");
			//���ò�ѯ�����user������
			u.setId(id);
			u.setUsername(name);
			u.setPassword(pwd); 
			u.setEmail(email);
			u.setGender(gender);
			//���ض���
			return u;
		}
		//��ѯ�������ݣ�����null
		return null;
	}
	
}
