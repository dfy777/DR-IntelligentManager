package com.example.demo.pojo;

import java.io.Serializable;

public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2885733896240232659L;
	
	private Integer device_id;
	private Integer fac_id;
	private Integer ord_id;
	private Integer status;
	private String dev_name;
	private String dev_location;
	
	public Integer getDevice_id() {
		return device_id;
	}
	
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	
	public Integer getFac_id() {
		return fac_id;
	}
	
	public void setFac_id(Integer fac_id) {
		this.fac_id = fac_id;
	}
	
	public Integer getOrd_id() {
		return ord_id;
	}
	
	public void setOrd_id(Integer ord_id) {
		this.ord_id = ord_id;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getDev_name() {
		return dev_name;
	}
	
	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}
	
	public String getDev_location() {
		return dev_location;
	}
	
	public void setDev_location(String dev_location) {
		this.dev_location = dev_location;
	}

	@Override
	public String toString() {
		return "Device [device_id=" + device_id + ", fac_id=" + fac_id + ", ord_id=" + ord_id + ", status=" + status
				+ ", dev_name=" + dev_name + ", dev_location=" + dev_location + "]";
	}
	
}
