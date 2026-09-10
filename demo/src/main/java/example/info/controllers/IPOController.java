package example.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.info.service.IPOService;

@RestController
@RequestMapping("/ipos") 
public class IPOController {
	
	@Autowired
	IPOService service;
	
	/*
	 * @GetMapping("/{name}") public IPO getProductById(@PathVariable String name) {
	 * return service.getIPObyID(name); }
	 */
	
	
	@GetMapping 
	// Or @PostMapping, depending on your request
    public ResponseEntity<?> getIpos() {
        return ResponseEntity.ok("Success");
    }


}
