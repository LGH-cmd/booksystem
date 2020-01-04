package com.iteima.system.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.BookDao;
import com.iteima.system.model.Book;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	
	BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<Book> list = bookDao.getAllBooks();
			
			req.setAttribute("BOOKLIST", list);
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf8");
			resp.getWriter().write("<h1>系统异常，请联系管理员 020-888666</h1>");
		}
	}
	
}
