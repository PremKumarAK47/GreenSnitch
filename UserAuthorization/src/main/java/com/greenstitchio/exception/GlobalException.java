package com.greenstitchio.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalException {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException mp){
		
		ErrorDetails error= new ErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation error");
		error.setErrDetails(mp.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException ue, WebRequest wreq){
		
		ErrorDetails error= new ErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ue.getMessage());
		error.setErrDetails(wreq.getDescription(false));
				
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		ErrorDetails error= new ErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(se.getMessage());
		error.setErrDetails(req.getDescription(false));
				
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
