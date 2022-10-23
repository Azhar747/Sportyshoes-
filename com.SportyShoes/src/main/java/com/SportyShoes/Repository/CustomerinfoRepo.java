package com.SportyShoes.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoes.Entity.Customerinfo;

@Repository
public interface CustomerinfoRepo extends CrudRepository<Customerinfo, Long> {
	

}
