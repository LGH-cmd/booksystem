package com.wei_xhh.booksystem.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wei_xhh.booksystem.dao.UserDao;
import com.wei_xhh.booksystem.model.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
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
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User user = userDao.login(username, password);
			if(user!=null) {
				//���û�����session
				HttpSession session = req.getSession();
				session.setAttribute("USER", user);
				
				//�ɹ�ʱ�ض���index.jspҳ��
				//resp.sendRedirect(req.getContextPath()+"/index.jsp");
				resp.sendRedirect(req.getContextPath()+"/bookServlet");
			}else {
				//ʧ��ʱת���ص�¼ҳ�棬������ʾ��Ϣ
				req.setAttribute("error", "�û������������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("ϵͳ�쳣������ϵ����Ա 10086");
		}
	}
	
}
