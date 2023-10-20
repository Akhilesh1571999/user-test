package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.NoSuchUserFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User saveUser(User user) {
		User save = repository.save(user);	
		return save;
	}

	@Override
	public User findUserById(int userId) {
		return repository.findById(userId).orElseThrow
				(()-> new NoSuchUserFoundException("user not found"));
	}

	@Override
	public List<User> findAll() {
     List<User> findAll = (List<User>) repository.findAll();		
     return findAll;
	}

	@Override
	public User updateUser(int userId, User updatedUser) {
		Optional<User> optionalUser = repository.findById(userId);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setFirst_name(updatedUser.getFirst_name());
			user.setLast_name(updatedUser.getLast_name());
			user.setCurrent_address(updatedUser.getCurrent_address());
			user.setPermanent_address((updatedUser.getPermanent_address()));
			return repository.save(user);
		} else {
			return null;
		}
	}

//	@Override
//	public int updateUser(int userId ,User user) {
//		Optional<User> optional = repository.findById(userId);
//		if(optional.isPresent()) {
//			User save = repository.save(user);
//			return save.getUser_id();
//		}
//		return 0;
//	}

	@Override
	public String deleteUser(int userId) {
		repository.deleteById(userId);	
		return "user deleted";
	}

}
