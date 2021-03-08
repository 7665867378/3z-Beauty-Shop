package com.threez.beauty.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threez.beauty.dao.impl.ProductDAOImpl;
import com.threez.beauty.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProductDAOImpl productDAOImpl;
	
	@GetMapping("/")
	public List<ResponseEntity<Product>> all () {
		
		
//		// TODO: Get the cookies
//		System.out.println(request.getCookies());
//		
//		model.addAttribute("productList",productDAOImpl.getAll());
//		return "index";
		
		return null;
		
	}
	
	@RequestMapping("/product-details/{id}")
	public String productDetails(Model model,@PathVariable("id") Integer id, HttpServletResponse response) {
//		
//		Product product = productDAOImpl.getProduct(id);
//		// TODO : setting the cookies to get the browsing activity of the user
//		Cookie cookie = new Cookie("id", product.getProductId().toString());
//		
//		model.addAttribute("product",product);
		return "pages/product_description";
	}
	
	
//	@PostMapping(value = "/product/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
//		Product savedProduct = this.productDAOImpl.saveProduct(product);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//													.path("/{id}")
//													.buildAndExpand(savedProduct.getProductId())
//												.toUri();
// 		this.productDAOImpl.saveProduct(product);
// 		return ResponseEntity.created(location).build();
//	}	
}
