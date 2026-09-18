package com.example.demo.stress;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface UserRepository extends CrudRepository<IPOUser, Long>{

	
	List<IPOUser> findByName(String name);
	
	
	@Query("SELECT u FROM IPOUser u WHERE u.name LIKE %:name%")
    List<IPOUser> findUsersByName(@Param("name") String name);
	
	
	@Query(value = "SELECT * FROM IPOUSER  WHERE name LIKE %:NAME%", nativeQuery = true)
    List<IPOUser> searchByNameNative(@Param("NAME") String NAME );
	
	
	@Transactional
    @Modifying
    @Query("UPDATE IPOUser u SET u.name = :newName WHERE u.id = :userId")
    int updateUserName(@Param("userId") Long id, @Param("newName") String newName);
	
	
	@Query("SELECT u FROM IPOUser u WHERE u.email = ?1")
    IPOUser findUserByEmail(String email);

}
