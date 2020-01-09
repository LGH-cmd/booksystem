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
		
		return list;
	}

}
