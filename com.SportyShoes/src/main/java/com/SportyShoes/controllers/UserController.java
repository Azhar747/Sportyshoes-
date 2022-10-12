package com.SportyShoes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@PostMapping("/Adduser")
	public String adduser() {
		return "AddUser.html";
		
	}
	@GetMapping("/User")
	public String user() {
		return "User.html";
		}
	
	@PostMapping("/SaveUser")
	public void saveuser() {
		
	}
	
	
	
	

}
