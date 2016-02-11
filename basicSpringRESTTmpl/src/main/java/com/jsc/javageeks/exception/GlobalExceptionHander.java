package com.jsc.javageeks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsc.javageeks.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHander /* extends ResponseEntityExceptionHandler */{

	@ExceptionHandler(value = NotAuthenticateException.class)
	public ResponseEntity<ErrorResponse> handleNotAutenticatedException(
			NotAuthenticateException ex) {
		ErrorResponse errorMessage = new ErrorResponse("FORBIDDEN",
				ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorMessage,
				HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorResponse> handleNULLPointerException(
			NullPointerException ex) {
		ErrorResponse errorMessage = new ErrorResponse("Something went wrong",
				ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ResponseEntity<String> handleException(NoHandlerFoundException ex) {
		String json = "{\"error\":\"Resource not found.\"}";
		return new ResponseEntity<String>(json, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		String errorMessage = "{\"error\":\"Something Went wrong.\"}";
		return new ResponseEntity<String>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}