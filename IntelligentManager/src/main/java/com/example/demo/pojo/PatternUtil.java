package com.example.demo.pojo;

import java.util.regex.Pattern;

public class PatternUtil {
	private static String namePattern = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$";
	private static String passwordPattern = "^[a-zA-Z]\\w{5,17}$";
	private static String emailPattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	private static String telephonePattern = "^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$"; 
			
	public static boolean validateName(String str) {
		return Pattern.matches(namePattern, str);
	}
	
	public static boolean validatePassword(String str) {
		return Pattern.matches(passwordPattern, str);
	}
	
	public static boolean validateEmail(String str) {
		return Pattern.matches(emailPattern, str);
	}
	
	public static boolean validateTelephone(String str) {
		return Pattern.matches(telephonePattern, str);
	}
}