package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.SportyShoes.Entity.Users;
import com.SportyShoes.Repository.UserRepo;
@Service
public class Userserivce {
   
	@Autowired
	UserRepo userrepo;
	
	public void Usersave(Users user) {
		
		userrepo.save(user);
		
	}
	public List<Users> getallusers() {
		List<Users> listuser = new ArrayList<>();
		userrepo.findAll().forEach(m -> listuser.add(m));
		return listuser;
	
		
	}
	
	public List<Users> findbykeyword(String keyword){
		List<Users> searchuser = new ArrayList<>();
		userrepo.findbykeyword(keyword).forEach(m -> searchuser.add(m));
		return searchuser;
	}
}
