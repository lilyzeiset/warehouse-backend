package com.skillstorm.project.exceptions;

/**
 * Runtime exception to be thrown when trying to add an item
 *   to a warehouse that is at max capacity
 * @author Lily Zeiset
 *
 */
public class ExceedMaxCapacityException extends RuntimeException{
	public ExceedMaxCapacityException() {
		super("This action would exceed the maximum capacity of the warehouse.");
	}
}
