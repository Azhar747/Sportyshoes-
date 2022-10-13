package com.SportyShoes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.Entity.Users;

public interface UserRepo extends CrudRepository<Users, Integer> {
	
	@Query("from Users u where u.firstname like %:keyword% or u.lastname like %:keyword% or u.email like %:keyword%")
	public List<Users> findbykeyword(String keyword);
	
	

}
