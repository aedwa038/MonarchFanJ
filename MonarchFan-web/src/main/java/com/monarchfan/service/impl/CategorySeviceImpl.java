package com.monarchfan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monarchfan.repository.CategoryRepository;
import com.monarchfan.service.CategoryService;
import com.monarhfan.model.Category;
@Service
public class CategorySeviceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		
		return categoryRepository.getAllCategories();
	}

	@Override
	public Category getCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryById(id);
	}

}
