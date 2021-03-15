package com.threez.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threez.beauty.dao.ShoppingCartDAO;
import com.threez.beauty.model.Product;
import com.threez.beauty.model.ShoppingCart;

@RestController
@RequestMapping("/shoppingCarts")
public class ShoppingCartController {
	
	
	@Autowired 
	private ShoppingCartDAO shoppingCartDAO;
	
	
	@PostMapping(value = "/add-to-cart/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> addToCart(@PathVariable Integer cartId, @RequestBody Product product){
		
		ShoppingCart cart = this.shoppingCartDAO.addToCart(this.shoppingCartDAO.getById(cartId), product);
		
		return new ResponseEntity<ShoppingCart>(cart,HttpStatus.OK);
	}
	
}
