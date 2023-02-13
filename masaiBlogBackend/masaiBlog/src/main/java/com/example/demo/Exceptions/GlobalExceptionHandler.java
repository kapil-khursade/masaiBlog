package com.example.demo.Exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ValidationException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyError> constrainVolationHandler(ConstraintViolationException ce, WebRequest req) {

		MyError err = new MyError();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getSQLException().getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> validationVolationHandler(MethodArgumentNotValidException ce, WebRequest req) {

		MyError err = new MyError();
		
		  Map<String, String> errors = new HashMap<>();
		    ce.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
	        
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(errors.toString());
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
