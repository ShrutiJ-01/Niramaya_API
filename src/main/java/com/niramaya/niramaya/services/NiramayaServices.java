package com.niramaya.niramaya.services;
import com.niramaya.niramaya.entities.UserProgressLog;

public interface NiramayaServices {
	
	public int addUser(String username);
	public int addProgressLog(UserProgressLog log);
}
