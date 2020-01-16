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
		conn.close();
		return list;
	}
	//ɾ��ͼ��
	public void deleteBookById(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from t_book where id=?";
		PreparedStatement prps = conn.prepareStatement(sql );
		prps.setString(1, id);
		prps.execute();
		conn.close();
		
	}
	// ���һ����
	public void addBook(Book book) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into t_book(id,name,price,bnum,category)"
				+ "values(?,?,?,?,?)";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, book.getId());
		prps.setString(2, book.getName());
		prps.setDouble(3, book.getPrice());
		prps.setInt(4, book.getBnum());
		prps.setString(5, book.getCategory());
		
		prps.execute();
		conn.close();
	}
	// �ҵ������
	public Book findBookById(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from t_book where id=?";
		
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, id);
		ResultSet set = prps.executeQuery();
		Book book = new Book();
		if(set.next()) {
			//��ȡÿһ���ֶε�ֵ
			String name = set.getString("name");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			
			book.setId(id);
			book.setName(name);
			book.setPrice(price);
			book.setBnum(bnum);
			book.setCategory(category);
			
		}
		conn.close();
		return book;
		
	}
	// ���� һ����
	public void updateBook(Book book) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "update t_book set name=?,price=?,bnum=?,category=? where id=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, book.getName());
		prps.setDouble(2, book.getPrice());
		prps.setInt(3, book.getBnum());
		prps.setString(4, book.getCategory());
		prps.setString(5, book.getId());
		
		prps.executeUpdate();
		conn.close();
	}

}
