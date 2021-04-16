package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;


@Controller
@RequestMapping("/index")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping(value="/login",consumes={"application/json"})
	@ResponseBody
	public Result<String> checkUserLogin(@RequestBody Map<String, String> userPara, 
										HttpServletRequest request, HttpServletResponse response) {
		String username = userPara.get("username");
		String psw = userPara.get("password");
		
		return  userService.checkUserLogin(username, psw, request, response);
		
//		if (result.getCode() == ResultEnum.SUCCESS.getCode()) {
//			HttpSession session = request.getSession();
//			User user = userService.findUser(username);
//			
//			
//			session.setAttribute("LoginUserId", user.getUser_id());
//			
//			
//			redisTemplate.opsForValue().set("LoginUser:" + user.getUser_id(), session.getId());
//		}
	}
	
	@PostMapping(value="/sign-up", consumes={"application/json"}) 
	@ResponseBody 
	public Result<String> saveNewUser(@RequestBody User user,
									HttpServletRequest request, HttpServletResponse response) {
		return userService.saveNewUser(user, request, response);
	}
}
