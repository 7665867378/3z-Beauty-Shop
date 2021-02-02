package com.threez.beauty.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threez.beauty.model.Product;
import com.threez.beauty.repository.ProductRepository;

@Service
public class ProductRepositoryImpl {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
}
