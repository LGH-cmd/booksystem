package com.wei_xhh.booksystem.test;

import org.junit.Test;

import com.wei_xhh.booksystem.dao.UserDao;

public class CheckNameTest {

	//测试用户名是否重复
	@Test
	public void CheckName() {
		
		UserDao userDao = new UserDao();
		try {
			boolean flag = userDao.checkName("user");
			if(flag) {
				System.out.println("可以注册");
			}else {
				System.out.println("不能注册");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出现错误，不能注册");
		}
	}
}
