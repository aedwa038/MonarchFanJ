package com.monarchfan.repository;

import java.util.List;

import com.monarhfan.model.Category;

public interface CategoryRepository {
	
	List<Category> getAllCategories();

	Category getCategoryById(String id);

}
