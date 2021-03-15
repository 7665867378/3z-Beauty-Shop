package com.threez.beauty.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threez.beauty.dao.ProductDAO;
import com.threez.beauty.model.Category;
import com.threez.beauty.model.Product;
import com.threez.beauty.repository.CategoryRepository;
import com.threez.beauty.repository.ProductRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
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
			
		this.productRepository.save(object);	
		return object;
	}

	@Override
	public Product update(Product updatedProduct) {
		
		// TODO: not yet tested
		Product product = this.productRepository.findById(updatedProduct.getProductId()).map(oldProduct -> {
																							
													oldProduct.setName(updatedProduct.getName());
													oldProduct.setDescription(updatedProduct.getDescription());
													oldProduct.setSku(updatedProduct.getSku());
										//			private String thumbnail;
													oldProduct.setUnit(updatedProduct.getUnit());
													oldProduct.setUnitPrice(updatedProduct.getUnitPrice());
													oldProduct.setWeight(updatedProduct.getWeight());
													oldProduct.setSize(updatedProduct.getSize());
													oldProduct.setImage(updatedProduct.getImage());
													oldProduct.setStock(updatedProduct.getStock());
													oldProduct.setCategoryList(updatedProduct.getCategoryList());
													oldProduct.setShoppingCartList(updatedProduct.getShoppingCartList());
													
													return this.productRepository.save(oldProduct);
													}).get();
		
		return product;
	}

	@Override
	public Product delete(Product object) {
		
		// This is only hiding visibility of the product
		
		Product archivedProduct = this.productRepository.findById(object.getProductId()).map(product -> {
																											// This will setting the archived 
																											product.setArchive(true);
																											return this.productRepository.save(product);
																										}).get();
		return archivedProduct;
	}

	@Override
	public Product getById(Integer id) {
		return this.productRepository.findById(id).get();
	}
	
}	
