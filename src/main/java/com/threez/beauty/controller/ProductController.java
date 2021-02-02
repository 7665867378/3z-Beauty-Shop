package com.threez.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
