package com.wei_xhh.booksystem.web.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wei_xhh.booksystem.dao.BookDao;
import com.wei_xhh.booksystem.model.Book;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private BookDao bookDao = new BookDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取所有图书
		try {
			ArrayList<Book> list = bookDao.findAllBooks();
			//将集合存储到request请求域中
			req.setAttribute("BOOKLIST", list);
			//转发请求到index.jsp页面，在页面进行取值
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("系统异常，请联系管理员 10086");
		}
		
	}
	
}	
