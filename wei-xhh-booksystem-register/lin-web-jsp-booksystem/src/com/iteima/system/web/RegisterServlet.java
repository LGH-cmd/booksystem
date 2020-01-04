package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.UserDao;
import com.iteima.system.model.User;
import com.iteima.system.util.Md5Util;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		
		//密码使用Md5加密处理
		String md5Pwd = Md5Util.encodeByMd5(password);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setGender(gender);
		
		try {
			userDao.register(user);
			
			resp.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("系统异常，请联系管理员 10086");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
