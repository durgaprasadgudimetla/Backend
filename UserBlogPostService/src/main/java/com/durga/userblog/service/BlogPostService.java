package com.durga.userblog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.userblog.dao.BlogPostRepository;
import com.durga.userblog.model.User;
@Service
public class BlogPostService {

	@Autowired
	private BlogPostRepository blogPostRepository;
	
	public List<User> getAllUser() {
		return blogPostRepository.findAll();
	}

	@Transactional
	public User insertUser(User user) {
		return blogPostRepository.save(user);
	}

	public User updateUser(User user) {
		return blogPostRepository.save(user);
	}

	public String deleteUser(User user) {
		 blogPostRepository.delete(user);
		 return "successfully deleted";
	}

}
