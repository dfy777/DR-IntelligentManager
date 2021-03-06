package com.example.demo.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;

public interface DeviceService {
	
	/**
	 * deprecated
	 * @param request
	 * @return
	 */
	Result<String> addDeviceToFactory(HttpServletRequest request);
	
	
	/**
	 * 查找当前工厂下的所有设备
	 * @param request
	 * @return
	 */
	Result<Map<String, String>> findDeviceinfo(HttpServletRequest request);
	
	
	/**
	 * 延时启动设备
	 * @return
	 */
	Result<String> delayStartProduce(HttpServletRequest request);
	
	
	/**
	 * 直接启动设备
	 */
	Result<String> straightStartProduce(HttpServletRequest request);
	
	
	/**
	 * 延时停止设备
	 * @return
	 */
	Result<String> delayStopProduce(HttpServletRequest request);
	
	
	/**
	 * 直接停止设备
	 */
	Result<String> straightStopProduce(HttpServletRequest request);
	
	
	/**
	 * 根据工厂id返回devices分页数据,根据页数和每页显示数量返回对应数据
	 * @param pageRequest
	 * @param request
	 * @return
	 */
	PageResult getDevicesOnPageByFacId(PageRequest pageRequest, HttpServletRequest request);
	
	
	/**
	 * 返回所有的devices分页数据,根据页数和每页显示数量返回对应数据
	 * @param pageRequest
	 * @param request
	 * @return
	 */
	PageResult getAllDevicesOnPage(PageRequest pageRequest, HttpServletRequest request);
	
	
	/**
	 * 记录当前设备id到session中
	 */
	Result<String> selectedDeviceSession(HttpServletRequest request);
	
	
	/**
	 * 返回设备生产信息以供前台charts显示
	 * @param request
	 * @return
	 */
	Result<Map<String, String>> showDeviceProgressOnCharts(HttpServletRequest request);
}
