package com.example.demo.pojo;

public enum ResultEnum {
	UNKNOWN_ERROR(-1, "unknow error"),
	SUCCESS(20000, "success"),
	CUSTOM_MSG(20001,"customize"),
	DATA_NOT_FOUND(20005, "data_not_found"),
	DATA_IS_NULL(20010,"data is null"),
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getMsg() {
		return this.msg;
	}
}