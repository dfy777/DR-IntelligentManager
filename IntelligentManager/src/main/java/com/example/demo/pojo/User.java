package com.example.demo.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1571787161524096374L;
	private Integer user_id;
	private String username;
	private String nickngame;
	private String email;
	private String password;
	private String telephone;
	private Integer usertype;
	
	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNickngame() {
		return nickngame;
	}
	
	public void setNickngame(String nickngame) {
		this.nickngame = nickngame;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Integer getUsertype() {
		return usertype;
	}
	
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", nickngame=" + nickngame + ", email=" + email
				+ ", password=" + password + ", telephone=" + telephone + ", usertype=" + usertype + "]";
	}
	
	
}
