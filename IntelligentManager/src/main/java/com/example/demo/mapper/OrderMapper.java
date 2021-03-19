package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Order;

@Mapper
public interface OrderMapper {
	
	public Order getOrderById(Integer id);
	
	public void updateOrder(Order order);
	
	public void deleteOrderById(Integer id);
	
	public void insertOrder(Order order);
}
