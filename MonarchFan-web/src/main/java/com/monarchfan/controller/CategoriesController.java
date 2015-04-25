package com.monarchfan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monarchfan.service.CategoryService;
import com.monarchfan.service.TopicService;
import com.monarhfan.model.Category;

@Controller()
@RequestMapping("/categories/")
public class CategoriesController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TopicService topicService;
	

	@RequestMapping
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "categories";

	}
	
	
	@RequestMapping("/{id}")
	public String getCategoryById(Model model,  @PathVariable("id") String id) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		model.addAttribute("topics", topicService.getTopicsByCategory(String.valueOf(category.getId())));
		return "category";

	}

}
