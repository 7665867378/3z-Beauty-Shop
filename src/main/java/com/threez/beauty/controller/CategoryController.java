package com.threez.beauty.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threez.beauty.dao.CategoryDAO;
import com.threez.beauty.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	
	@Autowired
	private CategoryDAO categoryDAO;
	
//	@GetMapping(value = "/")
//	private HttpEntity<List<Category>> getAllCategory(){
//		
//		List<Category> categoryList = this.categoryDAO.getAll();
//		
//		return new ResponseEntity<>(categoryList,HttpStatus.OK);
//	}
//	
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	private HttpEntity<Category> getCategoryById(@PathVariable Long id){
//		
//		Category category = this.categoryDAO.getById(Integer.parseInt(id.toString()));
//		
//		return new ResponseEntity<Category>(category,HttpStatus.OK);
//	}
	
	@PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	private HttpEntity<Category> saveCategory(@RequestBody Category category){
		
		this.categoryDAO.save(category);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
}