package com.threez.beauty.dao;

import org.springframework.stereotype.Component;

import com.threez.beauty.model.Product;
import com.threez.beauty.model.ShoppingCart;

@Component
public interface ShoppingCartDAO extends GenericCRUD<ShoppingCart> {
	
	ShoppingCart addToCart(ShoppingCart cart, Product product);
}
