package com.adong3.fullstack;

import javax.annotation.Resource;

import com.adong3.fullstack.dao.UserDao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FullstackApplicationTests {
	@Resource
	UserDao userDao;

	@Test
	void contextLoads() {
		System.out.println("testGetUser=" + userDao.getUser("alex"));
	}

}
