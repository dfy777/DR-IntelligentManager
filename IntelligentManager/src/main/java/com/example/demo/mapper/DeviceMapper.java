package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Device;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface DeviceMapper {
	Device findDeviceById(Integer id);
	
	void deleteDeviceById(Integer id);
	
	void updateDevice(Device device);
	
	void insertDevice(Device device);
	
	Integer findDevIdByName(String name);
	
	Integer findDevIdByFacIdAndDevName(@Param("fid")Integer fid, @Param("devname")String devname);
	
	List<Device> getDeviceByFacIdOnPage(Integer id);
	
	List<Device> getAllDevices(Integer id);
	
	Device findDeviceByFacAndDevId(@Param("fid")Integer fid, @Param("did")Integer did);
	
	List<Device> findDevicesByFacId(@Param("fid")Integer fid);
	
	List<Map<String, Object>> delayStartProduce(@Param(value="sqlStr") String sqlStr);
	
	List<Map<String, Object>> delayStopProduce(@Param(value="sqlStr") String sqlStr);
	
	void updateDeviceStatusByDevId(@Param("dstatus")String dstatus, @Param("dev_id")Integer dev_id);
}
