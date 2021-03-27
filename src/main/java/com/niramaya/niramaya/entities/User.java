package com.niramaya.niramaya.entities;

public class User {

	private String username;
	private String id;
	
	//default constructor
	public User() {
		username="";
		id="";
	}
	
	//parameterized constructor
	public User(String username, String id) {
		super();
		this.username = username;
		this.id = id;
	}
	
	//getter function for username
	public String getUsername() {
		return username;
	}
	
	//setter function for username
	public void setUsername(String username) {
		this.username = username;
	}
	
	//getter function for id
	public String getId() {
		return id;
	}
	
	//setter function for id
	public void setId(String id) {
		this.id = id;
	}

	//overrriding to string method for user class
	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", getUsername()=" + getUsername() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
