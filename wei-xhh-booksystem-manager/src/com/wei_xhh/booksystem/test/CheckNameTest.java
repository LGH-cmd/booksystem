package com.wei_xhh.booksystem.test;

import org.junit.Test;

import com.wei_xhh.booksystem.dao.UserDao;

public class CheckNameTest {

	//�����û����Ƿ��ظ�
	@Test
	public void CheckName() {
		
		UserDao userDao = new UserDao();
		try {
			boolean flag = userDao.checkName("user");
			if(flag) {
				System.out.println("����ע��");
			}else {
				System.out.println("����ע��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ִ��󣬲���ע��");
		}
	}
}
