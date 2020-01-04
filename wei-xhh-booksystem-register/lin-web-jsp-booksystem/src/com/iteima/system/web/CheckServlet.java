package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.UserDao;

/**
 * 检查是否存在用户名
 * @author 温心雨i
 *
 */

@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求的用户名
		String username = req.getParameter("username");
		//调用dao的检查方法
		try {
			boolean flag = userDao.checkName(username);
			if(flag){
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
