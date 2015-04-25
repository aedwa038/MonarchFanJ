package com.monarhfan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({ @NamedQuery(name = Category.FIND_ALL, query = "from Category"),
	@NamedQuery(name = Category.GET, query = "from Category c where c.id = :id"),
	@NamedQuery(name = Category.GET_BY_NAME, query = "from Category c where c.categoryName = :categoryName") })
@Entity
@Table(name = "categories")
public class Category {
	public static final String FIND_ALL = "category.findAll";
	public static final String GET = "category.get";
	public static final String GET_BY_NAME = "category.getByCategoryName";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", unique = true, nullable = false)
	int id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories", targetEntity=Topic.class)
	List<Topic> topics;
	@Column(name = "category_name", unique = true, nullable = false)
	String categoryName;
	@Column(name = "category_description", nullable = false)
	String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
