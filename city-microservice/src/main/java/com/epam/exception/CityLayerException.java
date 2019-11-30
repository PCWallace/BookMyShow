package com.epam.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityLayerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CityException cityException;

	@SuppressWarnings("static-access")
	public CityLayerException(String message) {
		cityException.message = message;
	}

}
