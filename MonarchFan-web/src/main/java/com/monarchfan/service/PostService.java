package com.monarchfan.service;

import java.util.List;

import com.monarhfan.model.Post;

public interface PostService {
	
	List<Post> getAllPosts();

	Post getPostById(String id);

	List<Post> getPostByTopic(String topicId);
	
	List<Post> getPostByUserName(String userName);
	
	void savePost(Post post, String topicId, String userName);

}
