package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.pojo.Factory;
import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;

public interface FactoryService {
	PageResult getAllFactorisByPage(PageRequest pageRequest, HttpServletRequest request);
}
