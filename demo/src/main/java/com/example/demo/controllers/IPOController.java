package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.IPOAcceptanceService;
import com.example.demo.pojo.IPO;
import com.example.demo.services.IPOService;
import com.example.demo.stress.UserRepository;

@RestController
@RequestMapping("/ipos") 
public class IPOController {
	
	@Autowired
	IPOService service;
	
	@Autowired
	IPOAcceptanceService ser;
	
	
	
	@Autowired
	UserRepository userrepo;
	
	/*
	 * @Autowired InfoOnSpringTransaction trx;
	 */
	
	
	  @GetMapping("/{name}") 
	  public IPO getProductById(@PathVariable String name) {
	  return service.getIPObyID(name); }
	 
	
	  @GetMapping("/transaction") 
	  //@Transactional
	  public void testTransaction() {
		  
	   ser.executeComplexWorkflow(); 
	  //in.commit(ts);
	  
	  }
	  
		/*
		 * @GetMapping("/save") //@Transactional public User saveUser(User user) {
		 * 
		 * userrepo.save();
		 * 
		 * }
		 */
	  
	
	@GetMapping 
	// Or @PostMapping, depending on your request
    public ResponseEntity<?> getIpos() {
        return ResponseEntity.ok("Success");
    }


}
