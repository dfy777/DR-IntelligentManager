package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FactoryMapper;
import com.example.demo.myexcept.MyExceptionHandler;
import com.example.demo.pojo.CookieUtil;
import com.example.demo.pojo.DValueEnum;
import com.example.demo.pojo.Factory;
import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.PageUtil;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FactoryServiceImpl implements FactoryService {
	
	@Autowired
	FactoryMapper factoryMapper;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	@Override
	public Result<String> addFactory(HttpServletRequest request, Factory factory) {
		
		System.out.println(factory.toString());
		if (factory.getFac_location() == null || factory.getFac_name() == null ||
				factory.getPhone() == null || factory.getUsername() == null) {
			return ResultUtil.null_dataRes("信息不能为空");
		}
		
		Integer cid = Integer.parseInt(request.getSession().
						getAttribute(DValueEnum.LOGIN_USER_ID.getValue()).toString());
		factory.setClient_id(cid);
		
		factoryMapper.insertFactory(factory);
		return ResultUtil.successRes();
	}
	
	
	@Override
	public PageResult getAllFactorisByPage(PageRequest pageRequest, HttpServletRequest request) {
		return PageUtil.getPageResult(pageRequest, getAllFactoriesInfo(pageRequest, request));
	}
	
	
	/**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
	private PageInfo<Factory> getAllFactoriesInfo(PageRequest pageRequest, HttpServletRequest request) {
		try {
			int pageNum = pageRequest.getPageNum();
			int pageSize = pageRequest.getPageSize();
			int user_id = Integer.parseInt(CookieUtil.getCookieByNameCookie(request, 
											DValueEnum.COOKIE_USER_ID.getValue()).getValue());
			//System.out.println(user_id);
			
			if (pageNum <= 0 || pageSize <= 0) {
				throw new IllegalArgumentException("非法分页数据");
			}
			
			PageHelper.startPage(pageNum, pageSize);
			
			List<Factory> factoriesList = factoryMapper.selectFactoryPage(user_id);
			//System.out.println("pageo2k");
			return new PageInfo<Factory>(factoriesList);
		} catch (IllegalArgumentException e1) {
			MyExceptionHandler.takeLog(e1);
			return null;
		}
	}
	
	
	@Override
	public Result<String> selectedFactorySession(HttpServletRequest request) {
		String fac_id = request.getParameter("factory_id");
		HttpSession session = request.getSession();
		
		if (Integer.parseInt(fac_id) < 0 || fac_id == null) {
			return ResultUtil.invalid_data("非法工厂编号");
		}
		
		session.setAttribute(DValueEnum.CHECKED_FACTORY_ID.getValue(), fac_id);
		
		return ResultUtil.successRes();
	}
}
