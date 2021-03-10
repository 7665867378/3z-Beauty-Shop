package com.threez.beauty.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threez.beauty.dao.CategoryDAO;
import com.threez.beauty.model.Category;
import com.threez.beauty.repository.CategoryRepository;

@Service
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category get(Category object) {
		return this.categoryRepository.findById(object.getCategoryId()).get();
	}

	@Override
	public Category getById(Integer id) {
		return this.categoryRepository.findById((Long.parseLong(id.toString()))).get();
	}

	@Override
	public Category save(Category object) {
		Category newCategory = this.categoryRepository.save(object);
		return newCategory;
	}

	@Override
	public Category update(Category newCategory) {

		Category updateCategory = this.categoryRepository.findById(newCategory.getCategoryId())
														.map(category -> {
															 // This is the mapping for Update 
  															 category.setDescription(newCategory.getDescription());
  															 category.setName(newCategory.getName());
  															 category.setThumbnail(newCategory.getThumbnail());
  															 return this.categoryRepository.save(category);
														}).get();
		
		return updateCategory;
	}

	@Override
	public Category delete(Category object) {
		// TODO Auto-generated method stub
		return null;
	}

}
