package com.threez.beauty.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.threez.beauty.model.Category;
import com.threez.beauty.model.Product;

@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);
	
	@Query(value = "SELECT DISTINCT(c.name) FROM Category c WHERE c.name = :name ")
	Set<Category> findDistinctByName(@Param("name") String name);
}
