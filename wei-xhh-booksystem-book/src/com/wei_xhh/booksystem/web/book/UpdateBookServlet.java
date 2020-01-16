package com.wei_xhh.booksystem.web.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wei_xhh.booksystem.dao.BookDao;
import com.wei_xhh.booksystem.model.Book;

@WebServlet("/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	
	private BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String bnum = req.getParameter("bnum");
		String category = req.getParameter("category");
		
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setPrice(Double.parseDouble(price));
		book.setBnum(Integer.parseInt(bnum));
		book.setCategory(category);
		
		try {
			bookDao.updateBook(book);
			resp.sendRedirect(req.getContextPath() + "/bookServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("系统异常，请联系管理员 10086");
		}
	}
	
}
