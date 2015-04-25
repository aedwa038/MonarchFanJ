package com.monarchfan.service;

import java.util.List;

import com.monarhfan.model.Topic;

public interface TopicService {
	
	List<Topic> getAllTopics();

	Topic getTopicById(String id);
	
	List<Topic> getTopicsByCategory(String categoryId);
	
	List<Topic> getTopicsByUserName(String userName);

}
