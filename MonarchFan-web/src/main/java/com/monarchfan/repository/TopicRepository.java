package com.monarchfan.repository;

import java.util.List;

import com.monarhfan.model.Topic;

public interface TopicRepository {

	List<Topic> getAllTopics();

	Topic getTopicById(String id);
	
	List<Topic> getTopicsByCategory(String categoryId);
	
	List<Topic> getTopicsByUserName(String userName);

}
