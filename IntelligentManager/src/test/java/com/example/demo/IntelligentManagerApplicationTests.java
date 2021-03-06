package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.demo.mapper.DeviceMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.MyCommonFunc;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.PatternUtil;

@MapperScan("com.example.demo.mapper")
@SpringBootTest
class IntelligentManagerApplicationTests {

	//@Autowired
	//private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private DeviceMapper deviceMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	
	/**
	 * 测试redis使用
	 * @throws Exception
	 */
	public void testRedis() throws Exception {
		 
		//User user = userMapper.getUserById(3);
		//System.out.print(user);
		
		//redisTemplate.opsForValue().set("asdasfasd", "asdafasdf");
	}
	
	/**
	 * 测试正则表达式
	 * @throws Exception
	 */
	public void testRegex() throws Exception {
		
		
		System.out.println(PatternUtil.validateName("user123"));
		System.out.println(PatternUtil.validatePassword("qwe123"));
	}
	
	
	/**
	 * 测试ordermapper
	 */
	public void orderTest() throws Exception {
		Order order = new Order();
		order.setClient_id(3);
		order.setClientId(3);
		order.setDescription("简介123");
		order.setFac_id(3);
		order.generateOrd_name();
		order.setPay_status("未支付123");
		order.setPrice(4123);
		order.setStatus("进行中333");
		
		orderMapper.insertOrder(order);
	}
	
	/**
	 * 测试device的创建事件的sql语句
	 */
	@Test
	public void deviceSqlTest() {
	     
	    String rdname = MyCommonFunc.getRandomString(6);
		
		Integer num = 7;

		String datestr = MyCommonFunc.getDelayDateOnSecond(45);
		
		
		String sqlstr = "CREATE EVENT " + rdname +"\n"
				+ "ON SCHEDULE AT \""+ datestr + "\"\n"
				+ "ON COMPLETION NOT PRESERVE\n"
				+ "DO CALL start_produce(" + num.toString() + ");";
		
		
		deviceMapper.delayStartProduce(sqlstr);
		System.out.println(sqlstr);
	}
}
