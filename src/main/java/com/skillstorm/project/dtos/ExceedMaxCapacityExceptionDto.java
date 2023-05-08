package com.skillstorm.project.dtos;

/**
 * Data transfer object for ExceedMaxCapacity exception
 * @author Lily Zeiset
 *
 */
public class ExceedMaxCapacityExceptionDto {

	/**
	 * The error message that will be sent back to the frontend
	 */
	private String message;

	public ExceedMaxCapacityExceptionDto() {
		super();
	}

	public ExceedMaxCapacityExceptionDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
