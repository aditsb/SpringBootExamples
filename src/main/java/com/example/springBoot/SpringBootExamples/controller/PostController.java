package com.example.springBoot.SpringBootExamples.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springBoot.SpringBootExamples.dao.PostDAOService;
import com.example.springBoot.SpringBootExamples.dao.UserDAOService;
import com.example.springBoot.SpringBootExamples.exception.PostNotFoundException;
import com.example.springBoot.SpringBootExamples.exception.UserNotFoundException;
import com.example.springBoot.SpringBootExamples.model.PostBean;
import com.example.springBoot.SpringBootExamples.model.UserBean;

@RestController
public class PostController {

	@Autowired
	public PostDAOService postDAO;

	@Autowired
	public UserDAOService userDAO;

	@GetMapping(path = "/users/{id}/posts", produces = { "application/json" })
	public List<PostBean> getPostsforUser(@PathVariable int id) {
		List<PostBean> post = postDAO.findPostsforUser(id);
		if (post == null) {
			throw new PostNotFoundException("id-" + id);
		}
		return post;
	}

	@GetMapping(path = "/users/{id}/posts/{post-id}", produces = { "application/json" })
	public List<UserBean> getUsers() {
		return userDAO.findUsers();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody PostBean post) {
		UserBean savedUser = userDAO.findOne(id);
		if(savedUser==null){
			throw new UserNotFoundException("id-"+id);
		}

		post.setPostId(id);

		PostBean savedPost = postDAO.SavePost(post);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
