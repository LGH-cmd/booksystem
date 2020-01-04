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

		//����������ʹ��Md5���ܣ���֤�����ݿ�İ�������һ��
		String md5Pwd = Md5Util.encodeByMd5(password);
		
		try {
			User user = userDao.login(username, password);
			
			if(user!=null) {
				req.getSession().setAttribute("USER", user);
				
//				resp.sendRedirect(req.getContextPath()+"/index.jsp");
				resp.sendRedirect(req.getContextPath()+"/bookServlet");
			}else {
				//ʧ��ʱת���ص�¼ҳ�棬������ʾ��Ϣ
				req.setAttribute("error", "�û������������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf8");
			resp.getWriter().write("<h1>ϵͳ�쳣������ϵ����Ա 020-888666</h1>");

		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
