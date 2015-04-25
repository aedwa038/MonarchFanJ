package com.monarchfan.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monarchfan.repository.TopicRepository;
import com.monarhfan.model.Topic;
@Repository
public class TopicRepositoryImpl implements TopicRepository {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Topic> getAllTopics() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Topic.FIND_ALL);
		List<Topic> topics =  query.list();
		session.getTransaction().commit();
		session.close();
		return topics;
	}

	@Override
	public Topic getTopicById(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int topicId = Integer.parseInt(id);
		Query query = session.getNamedQuery(Topic.GET);
		query.setInteger("id", topicId);
		Topic topics =  (Topic) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return topics;
	}

	@Override
	public List<Topic> getTopicsByCategory(String categoryId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Topic.GET_BY_CATEGORY);
		int id = Integer.parseInt(categoryId);
		query.setInteger("categoryId", id);
		List<Topic> topics =  query.list();
		session.getTransaction().commit();
		session.close();
		return topics;
	}

	@Override
	public List<Topic> getTopicsByUserName(String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Topic.GET_BY_NAME);
		query.setParameter("userName", userName);
		List<Topic> topics =  query.list();
		session.getTransaction().commit();
		session.close();
		return topics;
	}

}
