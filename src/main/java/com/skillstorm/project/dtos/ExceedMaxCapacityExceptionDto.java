package com.skillstorm.project.dtos;

public class ExceedMaxCapacityExceptionDto {

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
