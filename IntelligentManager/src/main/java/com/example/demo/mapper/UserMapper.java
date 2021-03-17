package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.pojo.User;

@Mapper
public interface UserMapper {
	
	//@Select("SELECT * FROM user WHERE user_id=#{id}")
	public User getUserById(Integer id);
	
	@Update("UPDATE user SET nickname=#{nickName}, username=#{userName}, "
			+ "email=#{email}, password=#{password}, usertype=#{type} "
			+ "WHERE user_id=#{user_id}")
	public void updateUser(User user);
	
	@Delete("DELETE FROM user WHERE user_id=#{id}")
	public void deleteUserById(Integer id);
	
	@Insert("INSERT INTO user(nickname,username,password,email,usertype) "
			+ "VALUES(#{nickName},#{userName},#{password},#{email},#{type})")
	public void insertUser(User user);
}