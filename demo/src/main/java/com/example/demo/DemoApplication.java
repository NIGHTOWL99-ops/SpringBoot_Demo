package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.xmlconfig.IPOAllotmentProcess;

@SpringBootApplication
	

public class DemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 2. Retrieve the bean from the Spring IoC container
        IPOAllotmentProcess userService = (IPOAllotmentProcess) context.getBean("IPOAllotmentProcess");

        // 3. Use the bean
        userService.showAmount();
        userService.setSharesInvestedAmount(5666666);
        
       int count= context.getBeanDefinitionCount();
        
       System.out.println("=====================================");
       System.out.println("All Beans in XML File");
       System.out.println("======================================"+count);
  
       
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ApplicationContext ctx) {
        return args -> {
            System.out.println("=========================================");
            System.out.println("ALL REGISTERED SPRING BEANS:");
            System.out.println("=========================================");
           // ctx=new ClassPathXmlApplicationContext("beans.xml");
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
