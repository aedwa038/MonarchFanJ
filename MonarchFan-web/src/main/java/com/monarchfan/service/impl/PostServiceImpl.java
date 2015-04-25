package com.monarchfan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monarchfan.repository.PostRepository;
import com.monarchfan.repository.TopicRepository;
import com.monarchfan.repository.UserRepository;
import com.monarchfan.service.PostService;
import com.monarhfan.model.Post;
import com.monarhfan.model.Topic;
import com.monarhfan.model.User;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public List<Post> getAllPosts() {
		
		return postRepository.getAllPosts();
	}

	@Override
	public Post getPostById(String id) {
		
		return postRepository.getPostById(id);
	}

	@Override
	public List<Post> getPostByTopic(String topicId) {
		
		return postRepository.getPostByTopic(topicId);
	}

	@Override
	public void savePost(Post post, String topicId, String userName) {
		Topic topic = topicRepository.getTopicById(topicId);
		User user = userRepository.getUserbyUserName(userName);
		post.setTopic(topic);
		post.setUser(user);
		postRepository.savePost(post);
		
		
	}

	@Override
	public List<Post> getPostByUserName(String userName) {
		
		return postRepository.getPostByUserName(userName);
	}

}
