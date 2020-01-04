package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.BookDao;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

	BookDao bookDao = new BookDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		try {
			bookDao.deleteBookById(id);
			
			resp.getWriter().write("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("系统异常，删除失败");
		}
		
		
	}
	
}
