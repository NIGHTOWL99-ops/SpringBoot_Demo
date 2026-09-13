package com.example.demo.stress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	@Bean
	public InvesterType objInvesterType() {
		
		
		return new InvesterType();
	}
		
	

}
