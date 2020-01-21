package com.mohanty.Modelapp.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@GetMapping
	public String userWelcomePage() {
		return "Welcome to the user page";
	}

	@GetMapping(path = "/{user_id}")
	public String getUser(@PathVariable int userId) {
		
		return "Get user method called with user id:" + userId;
	}
	
	@PostMapping(path = "/createUser")
	public String createuser() {
		return "create user method called";
	}
}
