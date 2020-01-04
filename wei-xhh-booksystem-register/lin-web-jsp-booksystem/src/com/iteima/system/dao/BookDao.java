package com.iteima.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iteima.system.model.Book;
import com.iteima.system.util.JdbcUtil;

public class BookDao {

	//������е�ͼ��
	public ArrayList<Book> getAllBooks() throws Exception {
		
		//�������
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "select * from t_book";
		PreparedStatement prps = conn.prepareStatement(sql);
		
		ResultSet set = prps.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		while(set.next()) {
			String id = set.getString("id");
			String name = set.getString("name");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			
			Book book = new Book();
			book.setId(id);
			book.setName(name);
			book.setPrice(price);
			book.setBnum(bnum);
			book.setCategory(category);
			
			list.add(book);
			
		}
		
		return list;
	}
	
	//ɾ��ĳһ��ͼ��
	public void deleteBookById(String id) throws Exception {
		
		//�������
		Connection conn = JdbcUtil.getConnection();
		
		String sql ="delete from t_book where id=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		
		prps.setString(1, id);
		prps.execute();
		
		conn.close();
	}
	
	//���һ��ͼ��
	public void addBook(Book book) throws Exception {
		
		//�������
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "insert into t_book(id,name,price,bnum,category) values(?,?,?,?,?)";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, book.getId());
		prps.setString(2, book.getName());
		prps.setDouble(3, book.getPrice());
		prps.setInt(4, book.getBnum());
		prps.setString(5, book.getCategory());
		
		prps.execute();
		
		conn.close();
	}
	
	//��ѯһ����,�����ж���
	public ArrayList<Book> queryBookByName(String name) throws Exception {
		//�������
		Connection conn = JdbcUtil.getConnection();
		ArrayList<Book> list = new ArrayList<>();
		
		String sql = "select * from t_book where name=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, name);
		
		ResultSet set = prps.executeQuery();
		while(set.next()) {
			String id = set.getString("id");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			
			Book book = new Book();
			book.setId(id);
			book.setName(name);
			book.setBnum(bnum);
			book.setPrice(price);
			book.setCategory(category);
			
			list.add(book);
		}
		conn.close();
		return list;
		
	}
	
	//ʹ��id ����
	public Book findBookById(String id) throws Exception {
		//�������
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "select * from t_book where id=?";
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, id);
		
		ResultSet set = prps.executeQuery();
		if(set.next()) {
			String name = set.getString("name");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			
			Book book = new Book();
			book.setId(id);
			book.setName(name);
			book.setPrice(price);
			book.setBnum(bnum);
			book.setCategory(category);
			
			return book;
		}
		conn.close();
		return null;
	}
	
	//����ĳһ����
	public void updateBook(Book book) throws Exception {
		//�������
		Connection conn = JdbcUtil.getConnection();
		
		String sql = "update t_book set name=?,price=?,bnum=?,category=? where id=?";
		PreparedStatement prps = conn.prepareStatement(sql );
		
		prps.setString(1, book.getName());
		prps.setDouble(2, book.getPrice());
		prps.setInt(3, book.getBnum());
		prps.setString(4, book.getCategory());
		prps.setString(5, book.getId());
		prps.executeUpdate();//����
	
		conn.close();
	}
	
}
