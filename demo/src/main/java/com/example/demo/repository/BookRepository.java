package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.stress.IPOUser;

@Repository

public class BookRepository {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	
	
	public int save(IPOUser ipo) {
        String sql = "INSERT INTO IPOUSER (name, PH_NUMBERS ) VALUES (?, ?)";
        return jdbcTemplate.update(sql, ipo.getName(), ipo.getPhNumbers());
    }

}
