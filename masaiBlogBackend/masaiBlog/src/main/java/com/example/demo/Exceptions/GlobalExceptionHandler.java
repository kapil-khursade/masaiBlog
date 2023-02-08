package com.example.demo.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MasaiBlogException.class)
	public ResponseEntity<MyError> customerExceptionHandler(MasaiBlogException ce, WebRequest req) {

		MyError err = new MyError();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> myExceptionHandler(NoHandlerFoundException nhfe, WebRequest req) {

		MyError err = new MyError();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nhfe.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);

	}
}