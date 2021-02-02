package com.threez.beauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threez.beauty.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
