package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.User;

@Mapper
public interface UserMapper {
	
	public User getUserById(Integer id);
	
	public User getUserByName(String name);
	
	public void updateUser(User user);
	
	public int deleteUserById(Integer id);
	
	public void insertUser(User user);
	
	public String findPswByName(String name);
}
