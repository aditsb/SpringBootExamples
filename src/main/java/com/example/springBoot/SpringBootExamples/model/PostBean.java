package com.example.springBoot.SpringBootExamples.model;

public class PostBean {
	
	
	private int id;
	private String postContent;
	private int postId;
	private String author;
	
	
	public PostBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostBean(int id, String postContent, int postId, String author) {
		super();
		this.id = id;
		this.postContent = postContent;
		this.postId = postId;
		this.author = author;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPostContent() {
		return postContent;
	}


	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	
}
