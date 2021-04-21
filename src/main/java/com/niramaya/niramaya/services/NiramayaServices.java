package com.niramaya.niramaya.services;
import com.niramaya.niramaya.entities.UserProgressLog;

public interface NiramayaServices {

    public int addUser(String username,String deviceId);
    public UserProgressLog addProgressLog(UserProgressLog log);
    public UserProgressLog getWeeklyProgress(String username);
}