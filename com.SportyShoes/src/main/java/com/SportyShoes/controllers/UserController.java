package com.SportyShoes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.SportyShoes.Entity.Users;
import com.SportyShoes.service.Userserivce;

@Controller
public class UserController {
	
	@Autowired
	Userserivce userser;
	
	@PostMapping("/Adduser")
	public String adduser() {
		return "AddUser.html";
		
	}
	@GetMapping("/User")
	public String user(Model m) {
		
		List<Users>listuser= userser.getallusers();
		m.addAttribute("listuser", listuser);
		
		return "User.html";
		}
	
	@PostMapping("/SaveUser")
	public String saveuser(Users user) {
		
		userser.Usersave(user);
		
		return "Saveuser.html";
		
	}
	
	
	
	

}
