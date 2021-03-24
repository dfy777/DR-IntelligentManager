package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Result;
import com.example.demo.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	@PostMapping(value="/user",consumes={"application/json"})
	@ResponseBody
	public Result<String> checkUserLogin(@RequestBody Map<String, String> user) {
		String username = user.get("username");
		String psw = user.get("password");
		
		return userService.checkUserLogin(username, psw);
	}
}
