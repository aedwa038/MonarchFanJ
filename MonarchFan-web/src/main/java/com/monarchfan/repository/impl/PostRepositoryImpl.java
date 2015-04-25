package com.monarchfan.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monarchfan.repository.PostRepository;
import com.monarhfan.model.Post;

@Repository
public class PostRepositoryImpl implements PostRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Post> getAllPosts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Post.FIND_ALL);
		List<Post> posts = query.list();
		session.getTransaction().commit();
		session.close();
		return posts;
	}

	@Override
	public Post getPostById(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int postId = Integer.parseInt(id);
		Query query = session.getNamedQuery(Post.GET);
		query.setInteger("id", postId);
		Post post = (Post) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return post;
	}

	@Override
	public List<Post> getPostByTopic(String topicId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int id = Integer.parseInt(topicId);
		Query query = session.getNamedQuery(Post.GET_BY_TOPIC);
		query.setInteger("topicId", id);
		List<Post> posts = query.list();
		session.getTransaction().commit();
		session.close();
		return posts;
	}

	@Override
	public void savePost(Post post) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(post);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Post> getPostByUserName(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery(Post.GET_BY_NAME);
		query.setParameter("userName", userName);
		List<Post> posts = query.list();
		session.getTransaction().commit();
		session.close();
		return posts;
	}

}
