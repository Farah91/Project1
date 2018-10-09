package com.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public Boolean validateUser(String username,String password) {
		
		User user = userDao.getUserByUsernameAndPassword(username, password);
		
		if(user == null) {
			return false;
		}else {
			return true;
		}
		
		
		
		
	}

	public List<User> getUserList() {
		return userDao.findAllUsers();
	}

	public void saveUser(User user) {
		
		userDao.saveUser(user);
		
	}

	public User findUserById(Integer id) {
		
		return userDao.findUserById(id);
	}
	


}
