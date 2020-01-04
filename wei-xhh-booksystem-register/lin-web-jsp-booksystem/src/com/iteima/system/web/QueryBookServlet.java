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

@WebServlet("/queryBookServlet")
public class QueryBookServlet extends HttpServlet {

	BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = new String(req.getParameter("name").getBytes("ISO8859_1"),"utf-8");
	
		try {
			if(name.equals("")) {
				resp.sendRedirect(req.getContextPath()+"/bookServlet");
			}else {
				ArrayList<Book> list = bookDao.queryBookByName(name);
				
				req.setAttribute("BOOKLIST", list);
				
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf8");
			resp.getWriter().write("<h1>系统异常，请联系管理员 020-888666</h1>");
		}
	}
	
	
}
