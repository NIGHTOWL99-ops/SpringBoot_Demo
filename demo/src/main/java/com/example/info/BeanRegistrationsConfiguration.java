package com.example.info;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.example.demo.services.IPOService;
@Configuration
@Import(BeanRegistrationsConfiguration.MyBeanRegistrar.class)
public class BeanRegistrationsConfiguration {
	
	
	
	    static class MyBeanRegistrar implements BeanRegistrar {
	        @Override
	        
	        public void register(BeanRegistry registry, Environment env) {
	            registry.registerBean(IPOService.class);
	            registry.registerBean("myService2", IPOService.class, spec -> spec
	                .prototype()
	                .lazyInit()
	                .primary()
	            );
	        }
	    }
	}


