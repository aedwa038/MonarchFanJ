package com.monarchfan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monarchfan.service.PostService;
import com.monarchfan.service.TopicService;
import com.monarhfan.model.Post;
import com.monarhfan.model.Topic;

@Controller
@RequestMapping("/topics/")
public class TopicsController {

	@Autowired
	TopicService topicService;

	@Autowired
	PostService postService;

	@RequestMapping
	public String getAllTopcics(Model model) {
		model.addAttribute("topics", topicService.getAllTopics());
		return "topics";
	}

	@RequestMapping("/{id}")
	public String getTopic(Model model, @PathVariable("id") String id) {
		Topic topic = topicService.getTopicById(id);
		model.addAttribute("topic", topic);
		model.addAttribute("posts", postService.getPostByTopic(id));
		model.addAttribute("post", new Post());

		return "topic";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("post") Post post,
			@PathVariable("id") String id, HttpServletRequest request) {

		System.out.println(request.getParameter("reply"));
		System.out.println("here here here here");
		System.out.println(post.getContents());
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		postService.savePost(post, id, name);
		System.out.println(name);

		return "redirect:/topics/" + id;
	}

}
