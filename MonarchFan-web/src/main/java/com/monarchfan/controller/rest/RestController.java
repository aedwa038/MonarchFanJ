package com.monarchfan.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monarchfan.service.CategoryService;
import com.monarchfan.service.PostService;
import com.monarchfan.service.TopicService;
import com.monarchfan.service.UserService;
import com.monarhfan.model.Category;
import com.monarhfan.model.Post;
import com.monarhfan.model.Topic;
import com.monarhfan.model.User;

@Controller
@RequestMapping("/rest/")
public class RestController {
	@Autowired
	UserService userService;

	@Autowired
	PostService postService;

	@Autowired
	TopicService topicService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/users")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public @ResponseBody User getUserById(@PathVariable("id") String id) {
		return userService.getUserbyId(id);
	}

	@RequestMapping("/categories")
	@ResponseBody
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@RequestMapping("/categories/{id}")
	@ResponseBody
	public Category getCategoryById(@PathVariable("id") String id) {
		return categoryService.getCategoryById(id);
	}

	@RequestMapping("/topics")
	@ResponseBody
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	
	@RequestMapping("/topics/{id}")
	@ResponseBody
	public Topic getTopicById(@PathVariable("id") String id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping("/posts")
	@ResponseBody
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
	
	@RequestMapping("/posts/{id}")
	@ResponseBody
	public Post getById(@PathVariable("id") String id) {
		return postService.getPostById(id);
	}

}
