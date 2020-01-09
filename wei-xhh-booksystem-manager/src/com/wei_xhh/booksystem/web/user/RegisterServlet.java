package com.wei_xhh.booksystem.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wei_xhh.booksystem.dao.UserDao;
import com.wei_xhh.booksystem.model.User;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		//获得注册数据
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		//封装到User
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		user.setEmail(email);
		user.setGender(gender);
		//注册
		try {
			userDao.register(user);
			//注册成功后跳转到登录页面
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("系统异常，请联系管理员 10086");
		}
	}
 
}
