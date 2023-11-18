package com.example.demo.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.errorlogbean;
import com.example.demo.repository.errorrepo;

@ControllerAdvice
public class globalexceptionhandler {
	@Autowired
	private errorrepo errepo;

	// handling specific exception
	@ExceptionHandler(WrongData.class)
	public ResponseEntity<?> resourceNotFoundHandling(WrongData exception, WebRequest request){
		errordetails errorDetails = 
				new errordetails(new Date(), exception.getMessage(), request.getDescription(false));
		errorlogbean eb=new errorlogbean( HttpStatus.NOT_FOUND ,exception.getMessage(),new Date());
		errepo.save(eb);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		errordetails errorDetails = 
				new errordetails(new Date(), exception.getMessage(), request.getDescription(false));
		errorlogbean eb=new errorlogbean( HttpStatus.NOT_FOUND ,exception.getMessage(),new Date());
		errepo.save(eb);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
