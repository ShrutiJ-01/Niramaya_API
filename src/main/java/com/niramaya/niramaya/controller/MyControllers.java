package com.niramaya.niramaya.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
//entities
import com.niramaya.niramaya.entities.User;
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
	@PostMapping("/create/{username}")
	public User createUser(@PathVariable String username) {
	return this.niramayaService.addUser(username);
	}
}
