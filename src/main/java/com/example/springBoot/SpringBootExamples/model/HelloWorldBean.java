package com.example.springBoot.SpringBootExamples.model;

public class HelloWorldBean {
	private String message;
	public HelloWorldBean() {
		// TODO Auto-generated constructor stub
	}
	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	public String getMessage() {
		return message;
	}

}
