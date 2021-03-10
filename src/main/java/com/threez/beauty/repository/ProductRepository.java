package com.threez.beauty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.threez.beauty.model.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "products")
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductId(@Param("id") Integer id);
}
