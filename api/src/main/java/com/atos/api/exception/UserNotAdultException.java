package com.atos.af.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserNotAdultException extends RuntimeException {

	public UserNotAdultException(String exception) {
		super(exception);
	}

}
