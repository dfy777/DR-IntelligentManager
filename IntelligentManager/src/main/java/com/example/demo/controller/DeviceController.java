package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.PageRequest;
import com.example.demo.pojo.PageResult;
import com.example.demo.pojo.Result;
import com.example.demo.service.DeviceService;

@Controller
public class DeviceController {
	
	@Autowired
	DeviceService deviceService;
	
	
	/**
	 * 展示设备列表
	 * @return
	 */
	@GetMapping("/home/factory/device/show")
	public String deviceShowPage() {
		return "device-list";
	}
	
	
	/**
	 * 查找当前工厂下的所有设备
	 * @param request
	 * @return
	 */
	@GetMapping("/home/factory/device/find-deviceinfo")
	@ResponseBody
	public Result<Map<String, String>> findDeviceinfo(HttpServletRequest request) {
		return deviceService.findDeviceinfo(request);
	}
	
	
	
	@PostMapping("/home/factory/device/add")
	@ResponseBody
	public Result<String> addDeviceToFactory(HttpServletRequest request) {
		return deviceService.addDeviceToFactory(request);
	}
	
	
	/**
	 * 	设备分页显示(根据工厂id)
	 * @param pageRequest
	 * @param request
	 * @return
	 */
	@PostMapping("/home/factory/device/show/select_byfacid")
	@ResponseBody
	public PageResult getAllOrderOnPageByFacId(@RequestBody PageRequest pageRequest, HttpServletRequest request) {
		return deviceService.getDevicesOnPageByFacId(pageRequest, request);
	}
	
	
	/**
	 * 获取全部设备 分页显示
	 * @param pageRequest
	 * @param request
	 * @return
	 */
	@PostMapping("/home/factory/device/show/select_all")
	@ResponseBody
	public PageResult getAllOrderOnPage(@RequestBody PageRequest pageRequest, HttpServletRequest request) {
		return deviceService.getAllDevicesOnPage(pageRequest, request);
	}
	
	
	/**
	 * 记住当前选择的设备
	 * @param request
	 * @return
	 */
	@PostMapping("/home/factory/device/show/select-device")
	@ResponseBody
	public Result<String> selectedDeviceSession(HttpServletRequest request) {
		return deviceService.selectedDeviceSession(request);
	}
	
	
	/**
	 * 定时启动设备
	 */
	@PostMapping("/home/factory/device/delay-start")
	@ResponseBody
	public Result<String> delayStartProduce(HttpServletRequest request) {
		return deviceService.delayStartProduce(request);
	}
	
	
	/**
	 * 直接启动设备
	 */
	@PostMapping("/home/factory/device/straight-start")
	@ResponseBody
	public Result<String> straightStartProduce(HttpServletRequest request) {
		return deviceService.straightStartProduce(request);
	}
	
	
	/**
	 * 定时停止设备
	 * @return
	 */
	@PostMapping("/home/factory/device/delay-stop")
	@ResponseBody
	public Result<String> delayStopProduce(HttpServletRequest request) {
		return deviceService.delayStopProduce(request);
	}
	
	
	/**
	 * 直接停止设备
	 */
	@PostMapping("/home/factory/device/straight-stop")
	@ResponseBody
	public Result<String> straightStopProduce(HttpServletRequest request) {
		return deviceService.straightStopProduce(request);
	}
	
	
	/**
	 * 用图标显示设备生产状况的方法
	 */
	@GetMapping("/home/factory/device/show/show-echarts")
	@ResponseBody
	public Result<Map<String, String>> showDeviceProgressOnCharts(HttpServletRequest request) {
		return deviceService.showDeviceProgressOnCharts(request);
	}
}

