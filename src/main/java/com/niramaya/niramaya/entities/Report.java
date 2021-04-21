package com.niramaya.niramaya.entities;
public class Report {
//new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	private String username;
	private String mindtype;
	private String bodytype;
	private String timestamp;
	
	//default constructor
	public Report() {
		username="";
		mindtype="";
		bodytype="";
		timestamp=""; 
	}
	
	//parameterized constructor
	public Report(String username,String mindtype,String bodytype,String timestamp) {
		super();
		this.username = username;
		this.mindtype= mindtype;
		this.bodytype=bodytype;       
		this.timestamp=timestamp;
	
	}
	
	//getter function for username
	public String getUsername() {
		return username;
	}
	
	//setter function for username
	public void setUsername(String username) {
		this.username = username;
	}
	//getter function for mindtype
		public String getMindtype() {
			return  mindtype;
		}
		
		//setter function for mindtypetype
		public void setMindtype(String mindtype) {
			this.mindtype = mindtype;
		}
		
		//getter function for bodytype
		public String getBodytype() {
			return bodytype;
		}
		
		//setter function for bodytype
		public void setBodytype(String bodytype) {
			this.bodytype = bodytype;
		}
	
	//getter function for time
	public String getTimestamp() {
		return timestamp;
	}
	
	//setter function for time
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	//overriding to string method for user class
	@Override
	public String toString() {
		return "Report [username=" + username + ",mindtype=" + mindtype + ",bodytype=" + bodytype + ", id=" + timestamp + ", getUsername()=" + getUsername() + ",getMindtype()=" + getMindtype() +",getBodytype()=" + getBodytype() 
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
