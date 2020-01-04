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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		//将明文密码使用Md5加密，保证和数据库的暗文密码一样
		String md5Pwd = Md5Util.encodeByMd5(password);
		
		try {
			User user = userDao.login(username, password);
			
			if(user!=null) {
				req.getSession().setAttribute("USER", user);
				
//				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				resp.sendRedirect(req.getContextPath()+"/bookServlet");
			}else {
				//失败时转发回登录页面，给出提示信息
				req.setAttribute("error", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf8");
			resp.getWriter().write("<h1>系统异常，请联系管理员 020-888666</h1>");

		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
