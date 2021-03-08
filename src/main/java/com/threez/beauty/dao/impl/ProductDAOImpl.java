package com.threez.beauty.dao.impl;

import java.util.List;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threez.beauty.dao.ProductDAO;
import com.threez.beauty.model.Product;
import com.threez.beauty.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private ProductRepository productRepository;
	
	// TODO: Logging
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ProductDAOImpl.class);

	@Override
	public List<Product> getAll() {
		List<Product> productList = this.productRepository.findAll();
		
		// TODO: Logging
		logger.trace("Fetching Success:" +productList );
		
		return productList;
	}

	@Override
	public Product get(Product object) {
		return this.productRepository.findById(object.getProductId()).get();
	}

	@Override
	public Product save(Product object) {
		try {
			if(!this.productRepository.existsById(object.getProductId())) {
				this.productRepository.save(object);
				return object;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public Product update(Product updatedProduct) {
		// TODO Auto-generated method stub
		try {
			
			if(this.productRepository.existsById(updatedProduct.getProductId())) {
				Product oldProduct = this.productRepository.findById(updatedProduct.getProductId()).get();
				oldProduct.setName(updatedProduct.getName());
				oldProduct.setDescription(updatedProduct.getDescription());
				oldProduct.setSku(updatedProduct.getSku());
//				private String thumbnail;
				oldProduct.setUnit(updatedProduct.getUnit());
				oldProduct.setUnitPrice(updatedProduct.getUnitPrice());
				oldProduct.setWeight(updatedProduct.getWeight());
				oldProduct.setSize(updatedProduct.getSize());
				oldProduct.setImage(updatedProduct.getImage());
				oldProduct.setStock(updatedProduct.getStock());
				this.productRepository.save(oldProduct);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Product delete(Product object) {
		// TODO Auto-generated method stub
		return null;
	}


	
}	
