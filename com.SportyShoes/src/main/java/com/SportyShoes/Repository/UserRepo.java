package com.SportyShoes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SportyShoes.Entity.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
	
	@Query(value="select * from Users u where u.firstname like %:keyword% or u.lastname like %:keyword% or u.email like %:keyword%",nativeQuery = true)
	public List<Users> findbykeyword(@Param("keyword") String keyword);
	
	

}
