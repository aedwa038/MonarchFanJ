package com.monarchfan.service;

import java.util.List;

import com.monarhfan.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUserbyId(String id);

	public User getUserbyUserName(String userName);
	
	public void saveUser(User user);
	

}
