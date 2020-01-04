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
		
		//��ȡ������û���
		String userName = req.getParameter("username");

		try {
			boolean flag = userDao.checkName(userName);
			if(flag){
				resp.getWriter().write("true"); //У��ͨ��
			}else{
				resp.getWriter().write("false"); //У��ʧ�ܣ���Ҫ�����û���ע��
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write("false");
		}
	}
	
}
