package com.example.demo.service;

import com.example.demo.myexcept.DeleteUserException;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;

public interface UserService {
	
	//save user function
	void saveUser(User user);
	
	//delete user function
	boolean deleteUser(Integer id) throws DeleteUserException;
	boolean deleteUser(User user) throws DeleteUserException;
	boolean deleteUser(String name) throws DeleteUserException;
	
	//find user
	User findUser(Integer id);
	User findUser(String username);
	
	//check user login
	Result<String> checkUserLogin(String name, String psw);
}
