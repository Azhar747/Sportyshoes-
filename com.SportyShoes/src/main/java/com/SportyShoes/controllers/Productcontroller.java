package com.SportyShoes.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SportyShoes.Entity.Category;
import com.SportyShoes.Entity.Product;
import com.SportyShoes.Repository.CatergoryRepo;
import com.SportyShoes.service.CatergoryService;
import com.SportyShoes.service.Productservice;

@Controller
public class Productcontroller {
	public static String uploadDir= System.getProperty("user.dir")+"/src/main/resources/static/img";
    @Autowired
     CatergoryService catser;
	
    @Autowired
    Productservice prdser;
   
	@GetMapping("/Products")
	public String getallProducts(Model m){
		
		
		List<Product> listprd=new ArrayList<>();
		listprd=prdser.getallPrd();
		Path imgpath=Paths.get(uploadDir);
		m.addAttribute("listprd", listprd);

		m.addAttribute("uploadDir", imgpath);
	    System.out.println(uploadDir);
		return "Products.html";
		
		
	}
	@PostMapping("/addproduct")
	public String addproduct(Model m) {
		
		List<Category> listcat = new ArrayList<>();
		listcat=catser.getallcat();
		System.out.println(listcat);
		m.addAttribute("listcat",listcat);
		
		return "addproduct.html";
	}
	
	@PostMapping("/SaveProduct")
	public String saveproduct(@ModelAttribute("prd") Product prd,@RequestParam("img") MultipartFile multipart,@RequestParam("listcat") Category listcat,@RequestParam("description") String desc ) throws IOException{
		
		
		prd.setCategory(listcat);
		prd.setDescription(desc);
		String imageUUID;
		if(!multipart.isEmpty()) {
			imageUUID =multipart.getOriginalFilename();        
			Path fileNameAndPath =Paths.get(uploadDir, imageUUID);      
			Files.write(fileNameAndPath, multipart.getBytes());            
		}else{                                      
	
			imageUUID=multipart.getOriginalFilename();
		}
		prd.setImagename(imageUUID);   
		prdser.saveproduct(prd);
		
		
		
		return "SaveProduct.html";
		
		
		
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteproduct(@PathVariable("id") Long id) {
		
		prdser.removeProductById(id);
		return "redirect:/Products";

	}
	@GetMapping("/deleteprdconfirm/{id}")
	public String deleteprdconfirm(@PathVariable("id") int id,Model m) {
		m.addAttribute("id", id);
		return "deleteprdconfrim";

	}
	
	@GetMapping("updateproduct/{id}")
	public String updateprd(@PathVariable("id") int id,Model m) {
		List<Category> listcat = new ArrayList<>();
		listcat=catser.getallcat();
		System.out.println(listcat);
		m.addAttribute("listcat",listcat);
		m.addAttribute("id", id);
		return "updateProduct.html";
	}
	@GetMapping("/Reports")
	public String reports(Model m) {
		List<Product> listprd=new ArrayList<>();
		listprd=prdser.getallPrd();
		Path imgpath=Paths.get(uploadDir);
		m.addAttribute("listprd", listprd);

		m.addAttribute("uploadDir", imgpath);
	    System.out.println(uploadDir);
	
		return "PurchaseReport.html";
	}
 
}
