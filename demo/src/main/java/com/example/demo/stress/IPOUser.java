package com.example.demo.stress;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IPOUser {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // Default constructor required by JPA
    public IPOUser() {} 

    public IPOUser(String name) { this.name = name; }
    public Integer getId() { return id; }
    public String getName() { return name; }

}
