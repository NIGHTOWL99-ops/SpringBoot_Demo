package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.IPO;
import com.example.demo.repository.IPORepository;
import com.example.demo.stress.IPOUser;
import com.example.demo.stress.PgenatinRepository;
import org.springframework.data.domain.*;

@Service
public class IPOService {
	
	@Autowired
	IPORepository repository;
	
	@Autowired
	PgenatinRepository re;
	
	public IPO getIPObyID(String name) {
		
		return repository.getIPObyID();
		
		
		
	    
		
	}
	@Transactional
	public Page<IPOUser> findAllUsers(Pageable pageable) {
        return re.findAll(pageable);
    }

}
