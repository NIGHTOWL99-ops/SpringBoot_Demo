package com.example.demo.info.google.advaced.auth;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp,
	    int status,
	    String error,
	    String message,
	    String path) {

}
