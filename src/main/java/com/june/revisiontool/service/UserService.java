package com.june.revisiontool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.revisiontool.model.User;
import com.june.revisiontool.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByName(String name) {
		return userDao.findByName(name);
	}
	
	
}
