package com.niramaya.niramaya.services;
import com.niramaya.niramaya.entities.User;
import com.niramaya.niramaya.entities.UserProgressLog;

public interface NiramayaServices {
	public User addUser(String username);
	public int addProgressLog(UserProgressLog log);
}
