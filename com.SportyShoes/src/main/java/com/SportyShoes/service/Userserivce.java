package com.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.SportyShoes.Entity.Users;
import com.SportyShoes.Repository.UserRepo;

public class Userserivce {
   
	@Autowired
	UserRepo userrepo;
	
	public void Usersave(Users user) {
		
		userrepo.save(user);
		
	}
}
