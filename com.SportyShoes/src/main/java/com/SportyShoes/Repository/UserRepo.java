package com.SportyShoes.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.Entity.Users;

public interface UserRepo extends CrudRepository<Users, Integer> {

}
