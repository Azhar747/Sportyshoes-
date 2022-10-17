package com.SportyShoes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.Entity.Category;
import com.SportyShoes.Entity.Product;

public interface ProductsRepo extends CrudRepository<Product, Integer>{
	
	@Query("from Product where category_id=:id")
	public List<Product> searchprd(int id);
	
}
