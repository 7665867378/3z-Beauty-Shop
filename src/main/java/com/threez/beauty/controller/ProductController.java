package com.threez.beauty.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.threez.beauty.model.Product;
import com.threez.beauty.repository.impl.ProductRepositoryImpl;


@Controller
public class ProductController {
	
	@Autowired
	public ProductRepositoryImpl productRepositoryImpl;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		model.addAttribute("productList",productRepositoryImpl.getAllProduct());
		return "index";
	}
	
	@PostMapping(value = "/product/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		
		Product savedProduct = this.productRepositoryImpl.saveProduct(product);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
													.path("/{id}")
													.buildAndExpand(savedProduct.getProductId())
												.toUri();
 		this.productRepositoryImpl.saveProduct(product);
 		return ResponseEntity.created(location).build();
	}	
}
