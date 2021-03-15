package com.threez.beauty.dao;

import java.util.Set;

import com.threez.beauty.model.Category;

public interface CategoryDAO extends GenericCRUD<Category> {
	Set<Category> getDistinctCategoryByName(String name);
}
