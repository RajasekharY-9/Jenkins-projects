package com.insta.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorInfo> UserException(UserException ue, WebRequest wr) {
		ErrorInfo er = new ErrorInfo(ue.getMessage(), wr.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> Exception(Exception ue, WebRequest wr) {
		ErrorInfo er = new ErrorInfo(ue.getMessage(), wr.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> MethodArgumentException(MethodArgumentNotValidException ue, WebRequest wr) {
		ErrorInfo er = new ErrorInfo(ue.getBindingResult().getFieldError().getDefaultMessage(), "Validation Error", LocalDateTime.now());

		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}
	
	
	
	
	
}
