package com.skillstorm.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skillstorm.project.exceptions.ExceedMaxCapacityException;

//This class will advise out controllers on specific Exceptions
@RestControllerAdvice // sends JSON data of error
public class GlobalExceptionHandler {
	// create your own exception classes (& DTOs) and monitor for them here (recommended)

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(ExceedMaxCapacityException.class)
	public ResponseEntity<String> handleExceedMaxCapacityException(ExceedMaxCapacityException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("This action would cause the maximum capacity of the warehouse to be exceeded.");
	}
}
