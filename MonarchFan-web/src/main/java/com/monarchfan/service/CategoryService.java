package com.monarchfan.service;

import java.util.List;

import com.monarhfan.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();
	
	Category getCategoryById(String id);
}
