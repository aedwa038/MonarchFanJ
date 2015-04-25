package com.monarchfan.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monarchfan.repository.UserRepository;
import com.monarhfan.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(User.FIND_ALL);
		List<User> userList = query.list();
		session.getTransaction().commit();
		session.close();
		return userList;
	}

	@Override
	public User getUserbyId(String id) {
		System.out.println(sessionFactory.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int userId = Integer.parseInt(id);
		User usertoReturn = null;
		Query query = session.getNamedQuery(User.GET);
		query.setInteger("id", userId);
		usertoReturn = (User) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();

		return usertoReturn;
	}

	@Override
	public User getUserbyUserName(String userName) {
		System.out.println(sessionFactory.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User usertoReturn = null;
		Query query = session.getNamedQuery(User.GET_BY_NAME);
		query.setString("userName", userName);
		usertoReturn = (User) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();

		return usertoReturn;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
