package com.monarchfan.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monarchfan.repository.CategoryRepository;
import com.monarhfan.model.Category;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery(Category.FIND_ALL);
		List<Category> categories =  query.list();
		session.getTransaction().commit();
		session.close();
		return categories;
	}

	@Override
	public Category getCategoryById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int catId = Integer.parseInt(id);
		Query query = session.getNamedQuery(Category.GET);
		query.setInteger("id", catId);
		Category category =  (Category) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return category;
	}

}
