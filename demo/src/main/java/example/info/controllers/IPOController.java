package example.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import example.info.pojo.IPO;
import example.info.service.IPOService;

@RestController
public class IPOController {
	
	@Autowired
	IPOService service;
	
	@GetMapping("/{id}")
    public IPO getProductById(@PathVariable Long id) {
        return service.getIPObyID("xyz");
    }	

}
