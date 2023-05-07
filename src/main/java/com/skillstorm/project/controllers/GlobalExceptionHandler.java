package com.skillstorm.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skillstorm.project.dtos.ExceedMaxCapacityExceptionDto;
import com.skillstorm.project.exceptions.ExceedMaxCapacityException;

//This class will advise out controllers on specific Exceptions
@RestControllerAdvice // sends JSON data of error
public class GlobalExceptionHandler {
	// create your own exception classes and monitor for them here

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(ExceedMaxCapacityException.class)
	public ExceedMaxCapacityExceptionDto handleExceedMaxCapacityException(ExceedMaxCapacityException e) {
		String msg = "Item not added. This action would cause the maximum capacity of the warehouse to be exceeded.";
		return new ExceedMaxCapacityExceptionDto(msg);
	}
}
