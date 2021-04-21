package com.niramaya.niramaya.services;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niramaya.niramaya.database.UserListDao;
import com.niramaya.niramaya.database.ProgressDao;
import com.niramaya.niramaya.entities.User;
import com.niramaya.niramaya.entities.UserProgressLog;
@Service
public class NiramayaServicesImpl implements NiramayaServices {
    @Autowired
    private UserListDao userListDao;
    @Autowired
    private ProgressDao progressDao;

    User new_user=new User();

    @Override
    public int addUser(String username,String deviceId) {
        new_user.setUsername(username);
        new_user.setDeviceId(deviceId);

        new_user.setTimestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));

        int status=userListDao.addUsertoUserlist(new_user);

        return status;
    }
    @Override
    public UserProgressLog addProgressLog(UserProgressLog log) {
        UserProgressLog placeholder=new UserProgressLog();
        try {
            //calculate ratio
            log.calculateRatio();
            log.setTimestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));


            int status=progressDao.updateUserProgress(log);    //save the log to database

            if(status==1)
            {
                return log;
            }
            else if(status==2)
            {
                placeholder.setTimestamp("Daily progress already submitted!");
                return placeholder;
            }
            else {
                placeholder.setTimestamp("Server could not update progress");
                return placeholder;
            }
        }
        catch(Exception e) {
            placeholder.setTimestamp("Server could not update progress");
            return placeholder;
        }
    }

    @Override
    public UserProgressLog getWeeklyProgress(String username) {
        UserProgressLog weeklylog=progressDao.getWeeklyLog(username);    //save the log to database
        return weeklylog;
    }
}