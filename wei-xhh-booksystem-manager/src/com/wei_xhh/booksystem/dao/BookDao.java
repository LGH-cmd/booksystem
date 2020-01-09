package com.wei_xhh.booksystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wei_xhh.booksystem.model.Book;
import com.wei_xhh.booksystem.util.JdbcUtil;

public class BookDao {
	
	//��ѯ����ͼ����Ϣ����װ��Book���󼯺Ϸ���
	public ArrayList<Book> findAllBooks() throws Exception{
		ArrayList<Book> list = new ArrayList<>();
		//��ѯt_book�������ݷ�װ��������
		//��ȡ����
		Connection conn = JdbcUtil.getConnection();
		//��ȡִ���߶���
		String sql = "select * from t_book";
		PreparedStatement prps = conn.prepareStatement(sql);
		//��ѯ�����ؽ����
		ResultSet set = prps.executeQuery();
		//��������
		while(set.next()){
			Book b = new Book();
			//��ȡÿһ���ֶε�ֵ
			String id = set.getString("id");
			String name = set.getString("name");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			//����ѯ������õ�Book������
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setBnum(bnum);
			b.setCategory(category);
			//��Ӷ��󵽼�����
			list.add(b);
		}
		
		return list;
	}

}
