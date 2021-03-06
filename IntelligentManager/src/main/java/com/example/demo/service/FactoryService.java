package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.example.demo.pojo.Factory;
import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;

public interface FactoryService {
	/**
	 * 返回工厂分页数据
	 * @param pageRequest
	 * @param request
	 * @return
	 */
	PageResult getAllFactorisByPage(PageRequest pageRequest, HttpServletRequest request);
	
	
	/**
	 * 记录当前工厂id到session
	 * @param request
	 * @return
	 */
	Result<String> selectedFactorySession(HttpServletRequest request);
	
	
	/**
	 * 添加工厂
	 * @param request
	 * @param factory
	 * @return
	 */
	Result<String> addFactory(HttpServletRequest request, Factory factory);
}
