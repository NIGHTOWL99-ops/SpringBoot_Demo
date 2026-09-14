package com.example.demo.stress;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<IPOUser, Long>{

	
	List<IPOUser> findByName(String name);
}
