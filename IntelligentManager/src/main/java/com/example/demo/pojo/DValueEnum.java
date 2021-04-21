package com.example.demo.pojo;

/**
 * DefaultValueEnum
 * @author wr568
 *
 */
public enum DValueEnum {
	COOKIE_USER_ID("cookie_userid"),
	LOGIN_USER_ID("LoginUserId"),
	LOGIN_USER("LoginUser");
	
	private String value;
	
	DValueEnum(String name) {
		this.value = name;
	}
	
	public String getValue() {
		return this.value;
	}
}