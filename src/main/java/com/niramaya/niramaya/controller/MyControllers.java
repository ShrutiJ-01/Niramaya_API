package com.niramaya.niramaya.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//entities
import com.niramaya.niramaya.entities.User;
import com.niramaya.niramaya.entities.UserProgressLog;
//service
import com.niramaya.niramaya.services.NiramayaServices;
@RestController
public class MyControllers {
	@Autowired
	private NiramayaServices niramayaService;
	
	@GetMapping("/home")
	public String home() {
		return "Hun Uzumaki Narutoooo!";
	}
	
	//create a user
	//mereko bohot zada assignment hai
	//saare log radha ko bhaavdalte kyunki wo acchi dikhti
	@PostMapping("/create/{username}")
	public User createUser(@PathVariable String username) {
		
	return this.niramayaService.addUser(username);
	
	}
	@PostMapping(path="/todaysprogress",consumes="application/json")
	public Map<String,Integer> updateUserProgress(@RequestBody UserProgressLog todaysLog) {
		
		//response will be a key value pair. This will be automatically sent as JSON object
		Map<String,Integer> response=new HashMap<String,Integer>(); 
		
		int updateStatus=this.niramayaService.addProgressLog(todaysLog);
		response.put("status",updateStatus);
		
		return response;		
		
	} 
	
}
