package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;

@MapperScan("com.example.demo.mapper")
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
		 
		User user = new User();
		user.setEmail("1223144");
		user.setNickname("n312");
		user.setPassword("12412");
		user.setTelephone("5555");
		user.setUsername("12");
		user.setUsertype(312);
		user.setUser_id(4);
		
		user = userMapper.getUserById(4);
		System.out.print(user);
	}
}
