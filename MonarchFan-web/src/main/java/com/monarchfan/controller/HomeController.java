package com.monarchfan.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monarchfan.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/")
	public String greeting(Model model, Principal principal) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "index";
	}

}
