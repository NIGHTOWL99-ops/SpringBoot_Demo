package com.example.demo.stress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<IPOUser, Long>{

	
	List<IPOUser> findByName(String name);
}
