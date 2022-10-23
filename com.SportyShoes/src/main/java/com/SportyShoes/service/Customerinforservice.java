package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.Entity.Customerinfo;
import com.SportyShoes.Entity.Product;
import com.SportyShoes.Repository.CustomerinfoRepo;
@Service
public class Customerinforservice {
	
	@Autowired
	CustomerinfoRepo custinfoser;
	public void  savecustinfo(Customerinfo cust) {
		 
		 custinfoser.save(cust);
		
	}
	
	public List<Customerinfo > getallcustomer(){
	
		List<Customerinfo> listcust = new ArrayList<>();
		custinfoser.findAll().forEach(m -> listcust.add(m));
		return listcust;
		
	}
}
