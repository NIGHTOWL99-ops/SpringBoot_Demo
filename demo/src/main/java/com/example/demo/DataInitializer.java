package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.UserProfile;
import com.example.demo.pojo.Userrrr;
import com.example.demo.repository.UserrrrRepository;

@Component
public class DataInitializer implements CommandLineRunner{

	
	private final UserrrrRepository userRepository;

    public DataInitializer(UserrrrRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Create the child entity
        UserProfile profile = new UserProfile("+1-555-0199", "123 Spring St, Tech City");

        // 2. Create the parent entity and link the profile
        Userrrr user = new Userrrr("Jane Doe", "jane.doe@example.com", profile);

        // 3. Save the parent entity (cascades automatically to the profile)
        userRepository.save(user);

        System.out.println("--- User and Profile successfully saved! ---");
    }
}
