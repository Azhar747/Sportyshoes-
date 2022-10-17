package com.SportyShoes.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SportyShoes.Entity.Category;
import com.SportyShoes.Entity.Product;
import com.SportyShoes.service.CatergoryService;
import com.SportyShoes.service.Productservice;

@Controller
public class Shopcontrollers {
	
	public static String uploadDir= System.getProperty("user.dir")+"/src/main/resources/static/img";
	
	@Autowired
	CatergoryService catser;
	
	@Autowired
	Productservice prdser;
	
	@GetMapping("/shop")
	public String shop(Model m) {
		
		List<Category> listcat = new ArrayList<>();
		listcat=catser.getallcat();
	    m.addAttribute("listcat", listcat);

		List<Product> listprd=new ArrayList<>();
		listprd=prdser.getallPrd();
		Path imgpath=Paths.get(uploadDir);
		m.addAttribute("listprd", listprd);

		
		
		m.addAttribute("uploadDir", imgpath);
	    System.out.println(uploadDir);
		
		return "Shop.html";
	}
	
	@GetMapping("/veiwproduct/?{id}")
	public String viewproduct() {
		
		return "viewproduct.html";
	}
	
	
}
