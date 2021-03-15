package com.threez.beauty.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threez.beauty.dao.ShoppingCartDAO;
import com.threez.beauty.model.Product;
import com.threez.beauty.model.ShoppingCart;
import com.threez.beauty.repository.ProductRepository;
import com.threez.beauty.repository.ShoppingCartRepository;

@Service
public class ShoppingCartDAOImpl implements ShoppingCartDAO {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<ShoppingCart> getAll() {
		return this.shoppingCartRepository.findAll();
	}

	@Override
	public ShoppingCart get(ShoppingCart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getById(Integer id) {
		return this.shoppingCartRepository.findById(id).get();
	}

	@Override
	public ShoppingCart save(ShoppingCart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart update(ShoppingCart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart delete(ShoppingCart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart addToCart(ShoppingCart cart, Product product) {
		// TODO Auto-generated method stub
		
		ShoppingCart shoppingCart = this.shoppingCartRepository.findById(cart.getShoppingCartID()).map( inCart -> {
			
			inCart.addProduct(this.productRepository.findById(product.getProductId()).get());
			return this.shoppingCartRepository.save(inCart);
		}).get();
		
		return shoppingCart;
	}

}
