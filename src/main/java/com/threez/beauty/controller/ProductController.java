package com.threez.beauty.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threez.beauty.dao.ProductDAO;
import com.threez.beauty.model.Category;
import com.threez.beauty.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	public ProductDAO productDAO;

	
	@PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
 		this.productDAO.save(product);
 		return new ResponseEntity<>(product,HttpStatus.OK);
	}	
	
	@DeleteMapping(value="/remove",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeProduct(@RequestBody Product product){
		
		Product archivedProduct = this.productDAO.delete(product);
		return new ResponseEntity<>(archivedProduct.getName()+" was removed",HttpStatus.OK);
	}
	
	@PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> editProduct(@RequestBody Product product){
		
		Product updatedProduct = this.productDAO.update(product);
		
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}
	
}
