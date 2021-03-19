package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Product;

@Mapper
public interface ProductMapper {
	public Product getProductById(Integer id);
	
	public void deleteProductById(Integer id);
	
	public void updateProduct(Product product);
	
	public void insertProduct(Product product);
}
