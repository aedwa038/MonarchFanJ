package com.monarchfan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monarchfan.service.PostService;
@Controller
@RequestMapping("/posts/")
public class PostsController {
	
	@Autowired
	PostService postService;

	@RequestMapping
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "posts";
	}
	
	@RequestMapping("/{id}")
	public String getpostById(Model model, @PathVariable("id") String id){
		model.addAttribute("post", postService.getPostById(id));
		
		return "post";
	}
}
