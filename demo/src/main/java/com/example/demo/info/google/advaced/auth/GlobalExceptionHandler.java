package com.example.demo.info.google.advaced.auth;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

	
	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFound(
	    		UserNotFoundException ex, WebRequest request) {
	        
	        ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            HttpStatus.NOT_FOUND.value(),
	            "Resource Not Found",
	            ex.getMessage(),
	            request.getDescription(false).replace("uri=", "")
	        );
	        
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
}
