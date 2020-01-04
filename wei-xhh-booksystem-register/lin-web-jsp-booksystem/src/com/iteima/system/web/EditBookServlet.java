package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.BookDao;
import com.iteima.system.model.Book;

@WebServlet("/editBookServlet")
public class EditBookServlet extends HttpServlet {
	BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String name = new String(req.getParameter("name").getBytes("ISO8859_1"),"utf-8");
		String price = req.getParameter("price");
		String bnum = req.getParameter("bnum");
		String category = new String(req.getParameter("category").getBytes("ISO8859_1"),"utf-8");
		
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setPrice(Double.parseDouble(price));
		book.setBnum(Integer.parseInt(bnum));
		book.setCategory(category);
		try {
			bookDao.updateBook(book);
			
			resp.sendRedirect(req.getContextPath()+"/bookServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf8");
			resp.getWriter().write("<h1>系统异常，请联系管理员 020-888666</h1>");
		}
	}
	
}
