package com.monarhfan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({ @NamedQuery(name = Topic.FIND_ALL, query = "from Topic"),
	@NamedQuery(name = Topic.GET, query = "from Topic t where t.id = :id"),
	@NamedQuery(name = Topic.GET_BY_NAME, query = "from Topic t where t.user.userName = :userName"),
	@NamedQuery(name = Topic.GET_BY_CATEGORY, query = "from Topic t where t.categories.id = :categoryId")})
@Entity
@Table(name = "topic")
public class Topic {
	public static final String FIND_ALL = "topic.findAll";
	public static final String GET = "topic.get";
	public static final String GET_BY_NAME = "topic.getByUserName";
	public static final String GET_BY_CATEGORY = "topic.getByCategory";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id", unique = true, nullable = false)
	int id;
	@Column(name = "topic_name", nullable = false)
	String topicName;
	@Column(name = "topic_description")
	String description;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", targetEntity = Post.class)
	List<Post> posts;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	User user;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinColumn(name = "category_id", nullable = false)
	Category categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
