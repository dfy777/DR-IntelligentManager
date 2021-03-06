package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Device;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Product;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface OrderMapper {
	
	Order getOrderById(Integer id);
	
	Order getOrderByOrdName(String ord_name);
	
	void updateOrder(Order order);
	
	void deleteOrderById(Integer id);
	
	void insertOrder(Order order);
	
	List<Order> getOrderByFacIdOnPage(Integer id);
	
	List<Order> getAllOrders(Integer id);
	
	Integer getProdIdByPordName(String name);
	
	Product getProductByPordName(String name);
	
}
