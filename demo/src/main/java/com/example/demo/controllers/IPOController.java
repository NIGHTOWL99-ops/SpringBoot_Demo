package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.IPOAcceptanceService;
import com.example.demo.pojo.IPO;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.IPOService;
import com.example.demo.stress.IPOUser;
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
	
    @Autowired
    BookRepository br;
	
    
    
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
	  
		
		
		  @GetMapping("/uname")
		  public List<IPOUser> fetchIPOUser(@RequestParam String uname) {
		  
		       return userrepo.findByName( uname);
		  
		  }
		 
	  @DeleteMapping("/delete/{id}")
		  public boolean deleteUser(@PathVariable Long id) {
		        if (userrepo.existsById(id)){
		        	userrepo.deleteById(id); // Deletes the record
		            return true;
		        }
		        return false; // Record not found
		    }
	  
	  
	  @PutMapping("/update/{id}")
	  public boolean updateuserIPO(@RequestBody IPOUser ip,@PathVariable Long id) {
	        if (userrepo.existsById(id)){
	        	ip.setId(id);
	        	userrepo.save(ip) ;// Deletes the record
	            return true;
	        }
	        return false; // Record not found
	    }
		
	  
	@PostMapping
	public IPOUser addIPOUser(@RequestBody IPOUser ipoUser) {
			  
			  
		 return userrepo.save(ipoUser);
     }
	  
	@PostMapping("/saveAllIPOUsers")
    public Iterable<IPOUser> saveUsers(@RequestBody List<IPOUser> PhNumbers) {
        return userrepo.saveAll(PhNumbers);
        
    }
	
	@GetMapping 
	// Or @PostMapping, depending on your request
    public ResponseEntity<?> getIpos() {
        return ResponseEntity.ok("Success");
    }
	
	@GetMapping("/fetchName/{name}")
	public List<IPOUser> fetchUsers(@PathVariable String name){
		
		return userrepo.findUsersByName(name);
	}

	@GetMapping("/fetchNameNative")
	public List<IPOUser> fetchUsersNative(@RequestParam String name){
		
		return userrepo.searchByNameNative(name);
	}
	
	@GetMapping("/updateNameNative")
	public int updateUserName(@RequestParam String name,@RequestParam Long id){
		
		return userrepo.updateUserName(id,name);
	}
	
	
	@GetMapping("/fetchNameJPQL/{email}")
	public IPOUser fetchUserNameJPQL(@PathVariable String email){
		
		return userrepo.findUserByEmail(email);
	}
	@PostMapping("/altuser")
    public String createBook(@RequestBody IPOUser ipo) {
        int result = br.save(ipo);
        return result > 0 ? "Book created successfully!" : "Failed to create book.";
    }


}
