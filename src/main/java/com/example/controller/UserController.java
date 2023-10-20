package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	

	@PostMapping("/save")
	public ResponseEntity<User> createNewUser(@RequestBody User user){
		User saveUser = service.saveUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}

//	@PutMapping("/update/{userId}")
//	public String updateUserById(@PathVariable int userId,@RequestBody User user) {
//		int updateUser = service.updateUser(userId, user);
//		if(updateUser == 0) {
//			return "user not found";
//		}
//		return "user updated successfully";
//	}
@PutMapping("/update/{userId}")
@CrossOrigin
public ResponseEntity<User> updateUserById(@PathVariable int userId, @RequestBody User updatedUser) {
	User updatedUserResult = service.updateUser(userId, updatedUser);

	if (updatedUserResult != null) {
		return new ResponseEntity<>(updatedUserResult, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

	@DeleteMapping ("/delete/{id}")
	public String deleteUserById(@PathVariable("id") int userId) {
		String deleteUser = service.deleteUser(userId);
		return "deleted";
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
		User findUserById = service.findUserById(userId);
		return new ResponseEntity<User>(findUserById,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		List<User> findAll = service.findAll();
		return findAll;
	}
	
}
