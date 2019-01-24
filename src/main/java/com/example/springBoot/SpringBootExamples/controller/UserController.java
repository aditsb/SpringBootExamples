package com.example.springBoot.SpringBootExamples.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springBoot.SpringBootExamples.dao.UserDAOService;
import com.example.springBoot.SpringBootExamples.exception.UserNotFoundException;
import com.example.springBoot.SpringBootExamples.model.UserBean;

@RestController
public class UserController {

	@Autowired
	public UserDAOService userDAO;

	@GetMapping(path = "/user/{id}", produces = { "application/json" })
	public Resource<UserBean> getUser(@PathVariable int id) {
		UserBean savedUse= userDAO.findOne(id);
		if(savedUse==null){
			throw new UserNotFoundException("id-"+id);
		}
		org.springframework.hateoas.Resource<UserBean> resource=new org.springframework.hateoas.Resource<UserBean>(savedUse);
		
		ControllerLinkBuilder controllerLinkBuilder= ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers());
		resource.add(controllerLinkBuilder.withRel("all-Users"));
		return resource;
	}

	@GetMapping(path = "/user", produces = { "application/json" })
	public List<UserBean> getUsers() {
		return userDAO.findUsers();
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean user) {
		UserBean savedUser=userDAO.SaveUser(user);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/user/{id}", produces = { "application/json" })
	public UserBean deleteUser(@PathVariable int id) {
		UserBean savedUse= userDAO.deletUser(id);
		if(savedUse==null){
			throw new UserNotFoundException("id-"+id);
		}
		return savedUse;
	}

}
