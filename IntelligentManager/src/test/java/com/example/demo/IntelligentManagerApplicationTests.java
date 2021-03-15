package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;

 
@SpringBootTest
class IntelligentManagerApplicationTests {

//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void test() throws Exception {
//		stringRedisTemplate.opsForValue().set("111", "sdasd");
//		assertEquals("sdasd", stringRedisTemplate.opsForValue().get("111"));
//	}

	@Test
	public void test() throws Exception {
		
		userMapper.deleteUserById(2);
	}
}
