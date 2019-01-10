package com.example.springBoot.SpringBootExamples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.SpringBootExamples.model.HelloWorldBean;

@RestController
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean", produces={"application/json"})
	public HelloWorldBean helloWorldBeam() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	///hello-world/path-variable/in28minutes
		@GetMapping(path = "/hello-world/path-variable/{name}", produces={"application/json"})
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World, %s", name));
		}

}
