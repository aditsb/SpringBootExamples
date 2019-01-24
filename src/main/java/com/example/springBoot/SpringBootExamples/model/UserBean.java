package com.example.springBoot.SpringBootExamples.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {

	// TODO Auto-generated constructor stub
	private int id;
	
	@Size(min=2 , message="Name must be of 2 chars")
	private String name;
	
	@Past 
	private Date dateOfBirth;

	public UserBean() {

	}

	public UserBean(int id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
