package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class WrongData extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public WrongData(String message)
	{
		super(message);
	}

}
