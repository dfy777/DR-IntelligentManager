package com.example.demo.dao;

import com.example.demo.pojo.User;

public interface UserDao {
	int addUser(User user);
	int deleteUser(User user);
	int updateUser(User user);
	
	User findById(String userId);
}
