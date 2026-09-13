package com.example.demo.info;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IPOAcceptanceService {
	
	
	
	
	
	@Transactional
    public void executeComplexWorkflow() {
        System.out.println("⚡ Executing non-database business logic...");
        
        // Mutate some state or hit an external API
        
		
		/*
		 * if (someFailureConditionIsTrue()) { throw new
		 * RuntimeException("Something went wrong!"); // Triggers custom rollback }
		 */
		 
    }
    
    private boolean someFailureConditionIsTrue() { return true; }

}
