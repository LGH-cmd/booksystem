package com.wei_xhh.booksystem.test;



import org.junit.Test;

import com.wei_xhh.booksystem.dao.UserDao;
import com.wei_xhh.booksystem.model.User;

public class LoginTest {
	//²âÊÔµÇÂ¼
	@Test
	public void Login() throws Exception {
		UserDao userDao = new UserDao();
		User user = userDao.login("user", "123456");
		System.out.print(user.toString());
	}
}
