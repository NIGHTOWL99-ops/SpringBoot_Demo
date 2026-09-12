package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.IPO;
import com.example.demo.repository.IPORepository;

@Service
public class IPOService {
	
	@Autowired
	IPORepository repository;
	
	public IPO getIPObyID(String name) {
		
		return repository.getIPObyID();
		
	}

}
