package com.jsc.javageeks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsc.javageeks.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHander extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NotAuthenticateException.class)
	public ResponseEntity<ErrorResponse> handleNotAutenticatedException(NotAuthenticateException ex) {
		ErrorResponse errorMessage = new ErrorResponse("FORBIDDEN", ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorMessage, HttpStatus.FORBIDDEN);
	}
}