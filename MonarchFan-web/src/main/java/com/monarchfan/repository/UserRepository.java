package com.monarchfan.repository;

import java.util.List;

import com.monarhfan.model.User;

public interface UserRepository {
	public List<User> getAllUsers();

	public User getUserbyId(String id);

	public User getUserbyUserName(String userName);
	
	public void saveUser(User user);

}
