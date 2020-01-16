package com.wei_xhh.booksystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wei_xhh.booksystem.model.Book;
import com.wei_xhh.booksystem.util.JdbcUtil;

public class BookDao {
	
	//查询所有图书信息，封装成Book对象集合返回
	public ArrayList<Book> findAllBooks() throws Exception{
		ArrayList<Book> list = new ArrayList<>();
		//查询t_book表，将数据封装到集合中
		//获取连接
		Connection conn = JdbcUtil.getConnection();
		//获取执行者对象
		String sql = "select * from t_book";
		PreparedStatement prps = conn.prepareStatement(sql);
		//查询并返回结果集
		ResultSet set = prps.executeQuery();
		//处理结果集
		while(set.next()){
			Book b = new Book();
			//获取每一个字段的值
			String id = set.getString("id");
			String name = set.getString("name");
			double price = set.getDouble("price");
			int bnum = set.getInt("bnum");
			String category = set.getString("category");
			//将查询结果设置到Book对象中
			b.setId(id);
			b.setName(name);
			b.setPrice(price);
			b.setBnum(bnum);
			b.setCategory(category);
			//添加对象到集合中
			list.add(b);
		}
		conn.close();
		return list;
	}
	//删除图书
	public void deleteBookById(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from t_book where id=?";
		PreparedStatement prps = conn.prepareStatement(sql );
		prps.setString(1, id);
		prps.execute();
		conn.close();
		
	}
	// 添加一本书
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
	// 找点击的书
	public Book findBookById(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from t_book where id=?";
		
		PreparedStatement prps = conn.prepareStatement(sql);
		prps.setString(1, id);
		ResultSet set = prps.executeQuery();
		Book book = new Book();
		if(set.next()) {
			//获取每一个字段的值
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
	// 更新 一本书
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
