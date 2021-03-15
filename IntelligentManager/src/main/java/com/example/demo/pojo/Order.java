package com.example.demo.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994604583240811380L;
	private Integer id;
	private LocalDate createDate;
	private String nickName;
	private String describe;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getNickname() {
		return nickName;
	}

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}
}
