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
	public int addUser(String username) {
		new_user.setUsername(username);
		
		new_user.setTimestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
		
		int status=userListDao.addUsertoUserlist(new_user);
		
		return status;
	}

	@Override
	public int addProgressLog(UserProgressLog log) {
		try {
			//calculate ratio
			log.calculateRatio();
			int status=progressDao.updateUserProgress(log);	//save the log to database
			return status;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}	

}
