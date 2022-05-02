package com.atos.af.api.exception.model;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	// General error message about nature of error
	private String message;

	// Specific errors in API request processing
	private List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

}
