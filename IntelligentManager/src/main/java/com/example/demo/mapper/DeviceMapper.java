package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Device;

@Mapper
public interface DeviceMapper {
	public Device getDeviceById(Integer id);
	
	public void deleteDeviceById(Integer id);
	
	public void updateDevice(Device device);
	
	public void insertDevice(Device device);
}
