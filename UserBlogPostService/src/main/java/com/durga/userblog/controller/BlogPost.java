package com.durga.userblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durga.userblog.model.User;
import com.durga.userblog.service.BlogPostService;

@RestController
@RequestMapping(value = "/blogpost")
public class BlogPost {
	@Autowired
	private BlogPostService blogPostService;
	
	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers(){
		return blogPostService.getAllUser();
	}
	
	@PostMapping(value = "/insertUser")
	public User insertUser(@RequestBody User user) {
		return blogPostService.insertUser(user);
	}
	
	@PostMapping(value = "/updateUser")
	public User updateUser(@RequestBody User user) {
		return blogPostService.updateUser(user);
	}
	
	@PutMapping(value = "/deleteUser")
	public String deleteUser(@RequestBody User user) {
		return blogPostService.deleteUser(user);
	}

}
