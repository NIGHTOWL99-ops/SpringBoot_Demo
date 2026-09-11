package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import example.info.pojo.IPO;


@Repository
public class IPORepository {
	
		
	public IPO getIPObyID(){
		
		return new IPO("XYZ",890);
			
			
		
		
	}

}
