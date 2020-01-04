package com.wei_xhh.booksystem.test;

import org.junit.Test;

import com.wei_xhh.booksystem.dao.UserDao;
import com.wei_xhh.booksystem.model.User;

public class RegisterTest {

	//≤‚ ‘◊¢≤·
	@Test
	public void RegisterUser() {
		
		User user = new User();
		user.setUsername("wei-xhh");
		user.setPassword("123456");
		user.setEmail("44@qq.com");
		user.setGender("ƒ–");
		
		UserDao userDao = new UserDao();
		try {
			userDao.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤Â»Î ß∞‹");
		}
	}
	
}
