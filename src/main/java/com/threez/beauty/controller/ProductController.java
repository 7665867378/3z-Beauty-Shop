package com.threez.beauty.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threez.beauty.dao.ProductDAO;
import com.threez.beauty.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	public ProductDAO productDAO;

	
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
//		Product savedProduct = this.productDAO.get(product);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//													.path("/{id}")
//													.buildAndExpand(savedProduct.getProductId())
//												.toUri();
 		this.productDAO.save(product);
 		return new ResponseEntity<>(product,HttpStatus.OK);
	}	
	
	
}
