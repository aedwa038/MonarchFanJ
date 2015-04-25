package com.monarchfan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monarchfan.service.PostService;
import com.monarchfan.service.TopicService;
import com.monarchfan.service.UserService;
import com.monarhfan.model.User;

@Controller()
@RequestMapping("/users/")
public class UserController {
	@Autowired
	UserService service;
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	PostService postService;

	@RequestMapping
	public String getUsers(Model model) {
		model.addAttribute("users", service.getAllUsers());
		return "users";
	}

	@RequestMapping("/{id}")
	public String getUser(Model model, @PathVariable("id") String id) {
		User user = service.getUserbyUserName(id);
		
		model.addAttribute("user", user);
		model.addAttribute("posts", postService.getPostByUserName(user.getUserName()));
		model.addAttribute("topics", topicService.getTopicsByUserName(user.getUserName()));
		return "user";
	}

}
