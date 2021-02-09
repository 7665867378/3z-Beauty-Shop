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
		return this.productRepository.findAll();
	}
	
	public Product getProduct(Integer productId) {
		return this.productRepository.findById(productId).get();
	}
	
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
}
