package com.skillstorm.project.exceptions;

public class ExceedMaxCapacityException extends RuntimeException{
	public ExceedMaxCapacityException() {
		super("This action would exceed the maximum capacity of the warehouse.");
	}
}
