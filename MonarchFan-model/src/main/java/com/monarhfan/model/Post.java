package com.monarhfan.model;

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
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = Post.FIND_ALL, query = "from Post"),
	@NamedQuery(name = Post.GET, query = "from Post p where p.id = :id"),
	@NamedQuery(name = Post.GET_BY_NAME, query = "from Post p where p.user.userName = :userName"),
	@NamedQuery(name = Post.GET_BY_TOPIC, query = "from Post p where p.topic.id = :topicId")})
@Entity
@Table(name = "posts")
public class Post {
	public static final String FIND_ALL = "post.findAll";
	public static final String GET = "post.get";
	public static final String GET_BY_NAME = "post.getbyuserName";
	public static final String GET_BY_TOPIC = "post.getbytopic";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", unique = true, nullable = false)
	int id;

	@Column(name = "post_contents", nullable = false, columnDefinition="text")
	String contents;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=User.class)
	@JoinColumn(name = "user_id", nullable = false)
	User user;
	@ManyToOne(fetch = FetchType.EAGER , targetEntity=Topic.class)
	@JoinColumn(name = "topic_id", nullable = false)
	Topic topic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
