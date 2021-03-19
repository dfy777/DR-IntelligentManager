package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.User;

@Mapper
public interface UserMapper {
	
	public User getUserById(Integer id);
	
	public void updateUser(User user);
	
	public void deleteUserById(Integer id);
	
	public void insertUser(User user);
}
