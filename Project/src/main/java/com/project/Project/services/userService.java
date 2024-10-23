package com.project.Project.services;

import com.project.Project.models.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.Project.dao.userDao;
import com.project.Project.models.User;

@Service
public class userService {
	@Autowired
	private userDao userDao;
	
	public List<User> getUsers(){
		return this.userDao.getAllUser();
	}
	
	public User addUser(User user) {
		try {
			return this.userDao.saveUser(user);
		} catch (DataIntegrityViolationException e) {
			// handle unique constraint violation, e.g., by throwing a custom exception
			throw new RuntimeException("Add user error");
		}
	}
	
	public User checkLogin(String username,String password) {
		return this.userDao.getUser(username, password);
	}

	public boolean checkUserExists(String username) {
		return this.userDao.userExists(username);
	}

	public User getUserByUsername(String username) {
	        return userDao.getUserByUsername(username);
	    }
}
