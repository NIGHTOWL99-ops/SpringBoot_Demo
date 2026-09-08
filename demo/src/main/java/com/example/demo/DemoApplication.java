package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            System.out.println("=========================================");
            System.out.println("ALL REGISTERED SPRING BEANS:");
            System.out.println("=========================================");

            // Retrieve all bean names
            String[] beanNames = ctx.getBeanDefinitionNames();
            
            // Optional: Sort them alphabetically
            Arrays.sort(beanNames);

            for (String beanName : beanNames) {
                // Print the name and its actual class type
                System.out.println(beanName + " -> " + ctx.getBean(beanName).getClass().getName());
            }
            
            System.out.println("Total Beans Registered: " + beanNames.length);
        };
    }

}
