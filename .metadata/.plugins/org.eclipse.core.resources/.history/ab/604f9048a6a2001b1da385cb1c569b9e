package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;

@MapperScan("com.example.demo.mapper")
@SpringBootTest
class IntelligentManagerApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void test() throws Exception {
//		stringRedisTemplate.opsForValue().set("111", "sdasd");
//		assertEquals("sdasd", stringRedisTemplate.opsForValue().get("111"));
//	}

	public void testRedis() throws Exception {
		 
		//User user = userMapper.getUserById(3);
		//System.out.print(user);
		
		redisTemplate.opsForValue().set("asdasfasd", "asdafasdf");
	}
	
	@Test
	public void testRegex() throws Exception {
		String pattern = "^[a-zA-Z]\\w{5,17}$";
		
		String psw = "da1ddfasdasf";
		
		System.out.println(java.util.regex.Pattern.matches(pattern, psw));		
	}
}
