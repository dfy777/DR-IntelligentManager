package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.myexcept.DeleteUserException;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.ResultUtil;
import com.example.demo.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * save user
	 */
	@Override
	public void saveUser(User user) {
		userMapper.insertUser(user);
	}
	
	/**
	 * delete user
	 */
	@Override
	public boolean deleteUser(Integer id) throws DeleteUserException {
		try {
			int res = userMapper.deleteUserById(id);
			if (res > 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			throw new DeleteUserException();
		}
	}
	
	@Override
	public boolean deleteUser(User user) throws DeleteUserException {
		try {
			return deleteUser(user.getUser_id());
		} catch (Exception e) {
			throw new DeleteUserException();
		}
	}
	
	@Override
	public boolean deleteUser(String name) throws DeleteUserException {
		try {
			User user = userMapper.getUserByName(name);
			return deleteUser(user.getUser_id());
		} catch (Exception e) {
			throw new DeleteUserException();
		}
	}
	
	
	/**
	 * find User
	 */
	
	
	@Override
	public User findUser(Integer id) {
		return userMapper.getUserById(id);
	}
	
	@Override
	public User findUser(String name) {
		return userMapper.getUserByName(name);
	}
	
	@Override
	public Result<String> checkUserLogin(String name, String psw) {
		
		String checked_psw =  userMapper.findPswByName(name);
		
		if (checked_psw == null) {
			return ResultUtil.data_not_foundRes("未找到用户");
		} else if (psw.equals(checked_psw)) {
			return ResultUtil.successRes("登陆成功");
		} else {
			return ResultUtil.unknown_errorReult("密码错误");
		}
	}
}
