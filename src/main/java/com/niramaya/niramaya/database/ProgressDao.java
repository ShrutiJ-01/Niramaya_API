package com.niramaya.niramaya.database;

import com.niramaya.niramaya.entities.UserProgressLog;
public interface ProgressDao{

	public int updateUserProgress(UserProgressLog progressLog);
	public UserProgressLog getWeeklyLog(String username);
}
