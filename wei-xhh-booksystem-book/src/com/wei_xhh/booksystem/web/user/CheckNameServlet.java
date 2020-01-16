package com.wei_xhh.booksystem.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wei_xhh.booksystem.dao.UserDao;

@WebServlet("/checkNameServlet")
public class CheckNameServlet extends HttpServlet {
	
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取请求的用户名
		String userName = req.getParameter("username");

		try {
			boolean flag = userDao.checkName(userName);
			if(flag){
				resp.getWriter().write("true"); //校验通过
			}else{
				resp.getWriter().write("false"); //校验失败，需要更换用户名注册
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("false");
		}
	}
	
}
