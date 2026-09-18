package com.example.demo.stress;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<IPOUser, Long>{

	
	List<IPOUser> findByName(String name);
	
	
	@Query("SELECT u FROM IPOUser u WHERE u.name LIKE %:name%")
    List<IPOUser> findUsersByName(@Param("name") String name);

}
