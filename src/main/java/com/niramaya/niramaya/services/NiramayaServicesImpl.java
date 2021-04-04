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
	
	User newUser=new User();

	@Override
	public User addUser(String username) {
		newUser.setUsername(username);
		newUser.setTimestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
		userListDao.save(newUser);//save newUser to database
		return newUser;
	}

	@Override
	public int addProgressLog(UserProgressLog log) {
		try {
			log.calculateRatio(); //calculate ratio
			progressDao.save(log);	//save the log to database
			return 1;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}	

}
