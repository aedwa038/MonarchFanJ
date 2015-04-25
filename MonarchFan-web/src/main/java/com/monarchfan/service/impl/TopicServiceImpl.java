package com.monarchfan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monarchfan.repository.TopicRepository;
import com.monarchfan.service.TopicService;
import com.monarhfan.model.Topic;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.getAllTopics();
	}

	@Override
	public Topic getTopicById(String id) {
		return topicRepository.getTopicById(id);
	}

	@Override
	public List<Topic> getTopicsByCategory(String categoryId) {
		return topicRepository.getTopicsByCategory(categoryId);
	}

	@Override
	public List<Topic> getTopicsByUserName(String userName) {
		
		return topicRepository.getTopicsByUserName(userName);
	}

}
