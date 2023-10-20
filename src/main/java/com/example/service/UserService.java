package com.example.service;

import java.util.List;

import com.example.model.User;


public interface UserService {
	
	User saveUser(User user);
	
	User findUserById(int userId);
	
	List<User> findAll();
	
//	int updateUser(int userId,User user);
	User updateUser(int userId, User updatedUser);
	String deleteUser(int userId);

}
