package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	@GetMapping("/index")
	public String index() {
		return "redirect:index.html";
	}
	
	@GetMapping("/index/test")
	public String testIndex() {
		return "ok1";
	}
	
	@GetMapping("/notpage")
	public String testIndex2() {
		return "ok2";
	}
	
	@GetMapping("/notpage/test")
	public String testIndex3() {
		return "ok3";
	}
}
