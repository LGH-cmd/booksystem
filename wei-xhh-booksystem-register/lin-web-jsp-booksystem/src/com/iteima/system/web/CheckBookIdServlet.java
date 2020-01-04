package com.iteima.system.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.dao.BookDao;
import com.iteima.system.model.Book;

/**
 * ����Ƿ�����û���
 * @author ������i
 *
 */

@WebServlet("/checkBookIdServlet")
public class CheckBookIdServlet extends HttpServlet {
	BookDao bookDao = new BookDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ������û���
		String id = req.getParameter("id");
		//����dao�ļ�鷽��
		try {
			Book book = bookDao.findBookById(id);
			if(book==null){
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
