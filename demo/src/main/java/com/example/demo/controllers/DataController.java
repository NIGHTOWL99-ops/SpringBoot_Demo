package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {
	
	
	@GetMapping("/shared")
    public String getSharedData() {
        return "Accessible by any authenticated user.";
    }

    @GetMapping("/secret")
    @PreAuthorize("hasRole('ADMIN')") // Maps to database authority 'ROLE_ADMIN'
    public String getAdminSecret() {
        return "Highly classified Oracle data.";
    }

}
