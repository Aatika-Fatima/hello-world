package com.security.web.model;

public class Movie {
	private String name;
	private String budget;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String name, String budget) {
		super();
		this.name = name;
		this.budget = budget;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
}
	
	