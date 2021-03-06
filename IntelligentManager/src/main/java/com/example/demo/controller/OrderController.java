package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;
import com.example.demo.service.OrderService;


@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/home/factory/order/show")
	public String orderShowPage() {
		return "order-list";
	}
	
	
	@GetMapping("/home/factory/order/add-order-show")
	public String addOrderShowPage() {
		return "order-add";
	}
	
	
	@PostMapping("/home/factory/order/add-order")
	@ResponseBody
	public Result<String> addOrderToFactory(@RequestBody Order order, HttpServletRequest request) {
		return orderService.addOrderToFactory(order, request);
	}
	
	
	@PostMapping("/home/factory/order/show/select_byfacid")
	@ResponseBody
	public PageResult getOrderOnPageByFacId(@RequestBody PageRequest pageRequest, HttpServletRequest request) {
		return orderService.getOrdersOnPageByFacId(pageRequest, request);
	}
	
	
	@PostMapping("/home/factory/order/show/select_all")
	@ResponseBody
	public PageResult getAllOrderByPage(@RequestBody PageRequest pageRequest, HttpServletRequest request) {
		return orderService.getAllOrdersOnPage(pageRequest, request);
	}
	
	
	@PostMapping("/home/factory/order/show/order-change")
	@ResponseBody
	public Result<String> changeOrder(HttpServletRequest request) {
		return orderService.changeOrder(request);
	}
}
