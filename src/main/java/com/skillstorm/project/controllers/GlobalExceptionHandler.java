package com.skillstorm.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skillstorm.project.dtos.ExceedMaxCapacityExceptionDto;
import com.skillstorm.project.exceptions.ExceedMaxCapacityException;

/**
 * Handles exceptions thrown elsewhere in the backend
 * @author Lily Zeiset
 *
 */
@RestControllerAdvice // sends JSON data of error
public class GlobalExceptionHandler {
	
	/**
	 * Handles ExceedMaxCapacity exception
	 * @param e The thrown error
	 * @return Data of the error with status 409 Conflict
	 */
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(ExceedMaxCapacityException.class)
	public ExceedMaxCapacityExceptionDto handleExceedMaxCapacityException(ExceedMaxCapacityException e) {
		String msg = "Item not added. This action would cause the maximum capacity of the warehouse to be exceeded.";
		return new ExceedMaxCapacityExceptionDto(msg);
	}
}
