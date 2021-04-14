package com.niramaya.niramaya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProgressLog {
	@Id
	@Column
	private String username;
	@Column
	private int current_progress;
	@Column
	private int expected_progress;
	@Column
	private float ratio;
	
	public UserProgressLog() {
		username="";
		current_progress=0;
		expected_progress=0;
		ratio=(float) 0.0;
	}
	
	public UserProgressLog(String username, int current_progress, int expected_progress) {
		super();
		this.username = username;
		this.current_progress = current_progress;
		this.expected_progress = expected_progress;
	}

	@Override
	public String toString() {
		return "UserProgressLog [username=" + username + ", current_progress=" + current_progress
				+ ", expected_progress=" + expected_progress + ", ratio=" + ratio + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCurrent_progress() {
		return current_progress;
	}

	public void setCurrent_progress(int current_progress) {
		this.current_progress = current_progress;
	}

	public int getExpected_progress() {
		return expected_progress;
	}

	public void setExpected_progress(int expected_progress) {
		this.expected_progress = expected_progress;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	public void calculateRatio() {
		
		//type casting to float since integer division returns an integer
		
		ratio=(float)current_progress/(float)expected_progress;
	}

}
