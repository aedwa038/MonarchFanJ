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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class User.
 *
 * @author Akeem
 */
@NamedQueries({
		@NamedQuery(name = User.FIND_ALL, query = "from User"),
		@NamedQuery(name = User.GET, query = "from User u where u.id = :id"),
		@NamedQuery(name = User.GET_BY_NAME, query = "from User u where u.userName = :userName") })
@Entity
@Table(name = "monarchUser")
public class User {

	public static final String FIND_ALL = "user.findAll";
	public static final String GET = "user.get";
	public static final String GET_BY_NAME = "user.getByUserName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	int id;
	@Column(name = "user_name", unique = true, nullable = false)
	String userName;
	@Column(name = "email_address", unique = true, nullable = false)
	String emailAddress;
	@JsonIgnore
	@Column(name = "user_password", nullable = false)
	String password;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = Post.class)
	List<Post> posts;
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
	UserRole role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@JsonProperty("password")
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonProperty("posts")
	@JsonIgnore
	public List<Post> getPosts() {
		return posts;
	}
	@JsonIgnore
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@JsonProperty("role")
	@JsonIgnore
	public UserRole getRole() {
		return role;
	}
	@JsonIgnore
	public void setRole(UserRole role) {
		this.role = role;
	}

}
