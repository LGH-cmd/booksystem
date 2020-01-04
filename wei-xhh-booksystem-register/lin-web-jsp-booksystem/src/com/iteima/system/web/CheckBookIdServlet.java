package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.BookDao;
import com.iteima.system.model.Book;

/**
 * 检查是否存在用户名
 * @author 温心雨i
 *
 */

@WebServlet("/checkBookIdServlet")
public class CheckBookIdServlet extends HttpServlet {
	BookDao bookDao = new BookDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求的用户名
		String id = req.getParameter("id");
		//调用dao的检查方法
		try {
			Book book = bookDao.findBookById(id);
			if(book==null){
				resp.getWriter().write("true"); //校验通过
			}else{
				resp.getWriter().write("false"); //校验失败，需要更换用户名注册
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("false");
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
