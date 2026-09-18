package com.example.demo.stress;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IPOUser {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String name;
    private String PhNumbers;
    
    private String email;
    

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNumbers() {
		return PhNumbers;
	}

	public void setPhNumbers(String phNumbers) {
		PhNumbers = phNumbers;
	}

	// Default constructor required by JPA
    public IPOUser() {} 

    public IPOUser(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getName() { return name; }

}
