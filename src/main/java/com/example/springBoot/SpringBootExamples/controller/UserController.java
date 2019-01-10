package com.example.springBoot.SpringBootExamples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.SpringBootExamples.dao.UserDAOService;
import com.example.springBoot.SpringBootExamples.model.UserBean;

@RestController
public class UserController {

	@Autowired
	public UserDAOService userDAO;

	@GetMapping(path = "/user/{id}", produces = { "application/json" })
	public UserBean getUser(@PathVariable int id) {
		return userDAO.findOne(id);
	}

	@GetMapping(path = "/user", produces = { "application/json" })
	public List<UserBean> getUsers() {
		return userDAO.findUsers();
	}

	@PostMapping(path = "/users")
	public void createUser(@RequestBody UserBean user) {
		userDAO.SaveUser(user);
	}

}
