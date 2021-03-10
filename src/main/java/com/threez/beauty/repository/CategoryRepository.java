package com.threez.beauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.threez.beauty.model.Category;

@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
