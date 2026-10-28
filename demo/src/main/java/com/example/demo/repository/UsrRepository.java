package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface UsrRepository extends JpaRepository<User, Long>{

	
	
	Optional<User> findByUsername(String username);
}
