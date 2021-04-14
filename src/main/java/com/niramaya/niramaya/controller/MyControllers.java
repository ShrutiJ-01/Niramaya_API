package com.niramaya.niramaya.controller;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//entities
import com.niramaya.niramaya.entities.UserProgressLog;
//service
import com.niramaya.niramaya.services.NiramayaServices;
@RestController
public class MyControllers {
	@Autowired
	private NiramayaServices niramayaService;
	Map<String,Integer> response=new HashMap<String,Integer>(); 
	
	
	@GetMapping("/home")
	public String home() {
		return "Hun Uzumaki Narutoooo!";
	}
	
	//create a user
	@PostMapping(path="/create",consumes="application/json")
	public Map<String,Integer> createUser(@RequestBody String requestJson) {
	
	//parsing incoming json to json object
	JSONObject jsonObject = (JSONObject) JSONValue.parse(requestJson);   
	
	//extracting value associated with key "username"
	String username = (String) jsonObject.get("username");  
	
	//redirecting to creation functions
	int createStatus= this.niramayaService.addUser(username);
	
	//creating JSON response
	response.clear();	
	response.put("status",createStatus);
	
	return response;
	
	}
	
	@PostMapping(path="/todaysprogress",consumes="application/json")
	public Map<String,Integer> updateUserProgress(@RequestBody String requestJson) {
		//parsing incoming json to json object
		
		JSONObject jsonObject = (JSONObject) JSONValue.parse(requestJson);   
		
		UserProgressLog todays_log=new UserProgressLog();
		
		//extracting value associated with keys
		todays_log.setUsername((String) jsonObject.get("username"));  
		todays_log.setCurrent_progress(Integer.valueOf(String.valueOf(jsonObject.get("current_progress"))));
		todays_log.setExpected_progress(Integer.valueOf(String.valueOf(jsonObject.get("expected_progress")))); 	
		
		//response will be a key value pair. This will be automatically sent as JSON object		
		
		int update_status=this.niramayaService.addProgressLog(todays_log);
		
		//creating and sending response
		response.clear();	
		response.put("status",update_status);
		
		return response;		
		
	} 
	
}
