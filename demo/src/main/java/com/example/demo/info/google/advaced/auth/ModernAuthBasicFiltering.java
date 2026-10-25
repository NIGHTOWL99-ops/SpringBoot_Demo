package com.example.demo.info.google.advaced.auth;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletResponse;

@Component
//@Configuration
@EnableWebSecurity
public class ModernAuthBasicFiltering {
	
	/*
	 * --Hey
	 */	
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable only for stateless APIs
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(PathRequest.toH2Console()).permitAll()
            		
                .requestMatchers("/ipos/**").permitAll() // Publicly available
                .requestMatchers("/ipos/**").hasRole("ADMIN") // Restricted by Role
                .anyRequest().authenticated() // Everything else requires authentication
            )
            .csrf(csrf -> csrf
                    .ignoringRequestMatchers("/h2-console/**")
                )
            .headers(headers -> headers
                    .frameOptions(frame -> frame.sameOrigin())
                )
            .formLogin(form -> form.permitAll()) // Enables built-in HTML Form Login
            .exceptionHandling(exception -> exception
                    .authenticationEntryPoint((request, response, authException) -> {
                        response.setContentType("application/json");
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"" + authException.getMessage() + "\"}");
                    }))
            .httpBasic(basic -> {}); // Enables Basic Authentication header support

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // Simple in-memory user configuration for local development
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("adminPass"))
                .roles("ADMIN")
                .build();
                
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("userPass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Securely hashes user passwords
    }
    
   
}



