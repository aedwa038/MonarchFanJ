package com.monarchfan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monarchfan.repository.UserRepository;
import com.monarchfan.service.UserService;
import com.monarhfan.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User getUserbyId(String id) {

		return userRepository.getUserbyId(id);
	}

	@Override
	public User getUserbyUserName(String userName) {
		return userRepository.getUserbyUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		userRepository.saveUser(user);

	}

}
