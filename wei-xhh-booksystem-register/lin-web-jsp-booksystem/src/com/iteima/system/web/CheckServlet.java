package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.UserDao;

/**
 * ����Ƿ�����û���
 * @author ������i
 *
 */

@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ������û���
		String username = req.getParameter("username");
		//����dao�ļ�鷽��
		try {
			boolean flag = userDao.checkName(username);
			if(flag){
				resp.getWriter().write("true"); //У��ͨ��
			}else{
				resp.getWriter().write("false"); //У��ʧ�ܣ���Ҫ�����û���ע��
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
