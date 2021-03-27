package com.niramaya.niramaya.services;
import org.springframework.stereotype.Service;

import com.niramaya.niramaya.entities.User;
@Service
public class NiramayaServicesImpl implements NiramayaServices {
	
	User newUser=new User();
	
	public NiramayaServicesImpl() {
		newUser.setId("675996effbnsmdfjh4c3f");
		newUser.setUsername("shruti");
	}	

	@Override
	public User addUser(String username) {
		// TODO Auto-generated method stub
		newUser.setUsername(username);
		return newUser;
	}	

}
