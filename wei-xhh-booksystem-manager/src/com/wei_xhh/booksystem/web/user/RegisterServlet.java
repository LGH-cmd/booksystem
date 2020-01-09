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
		//���ע������
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		//��װ��User
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passWord);
		user.setEmail(email);
		user.setGender(gender);
		//ע��
		try {
			userDao.register(user);
			//ע��ɹ�����ת����¼ҳ��
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("ϵͳ�쳣������ϵ����Ա 10086");
		}
	}
 
}
