package com.durga.userblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BLOGPOST")
public class BlogPosts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "blog_post_id")
	private Long blogPostId;
	@Column(name = "blog_post")
	private String blogPost;
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_id")
	//@JsonManagedReference
	private User user;

	public Long getBlogPostId() {
		return blogPostId;
	}

	public void setBlogPostId(Long blogPostId) {
		this.blogPostId = blogPostId;
	}

	public String getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(String blogPost) {
		this.blogPost = blogPost;
	}

	public User getUser() {
		return user;
	}
	

	public void setUser(User user) {
		this.user = user;
	}
	

}
