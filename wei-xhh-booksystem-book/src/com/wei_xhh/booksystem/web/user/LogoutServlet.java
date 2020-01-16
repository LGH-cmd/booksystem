package com.wei_xhh.booksystem.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ɾ�������Ӧ��session���е�USER����
		HttpSession session = req.getSession();
		session.removeAttribute("USER");
		
		//�ض�������login.jspҳ��
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		
	}
	
}
