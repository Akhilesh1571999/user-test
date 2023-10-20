package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.model.ExceptionResponse;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(NoSuchUserFoundException.class)
	@ResponseStatus(value =HttpStatus.NOT_FOUND)
	public ExceptionResponse handleException(NoSuchUserFoundException exception) {
	 ExceptionResponse exceptionResponse = new ExceptionResponse();
	 exceptionResponse.setErrorCode("Error_found");
	 exceptionResponse.setErrorMessage(exception.getMessage());
	 return exceptionResponse;
 }
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value =HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleException(Exception exception) {
		 ExceptionResponse exceptionResponse = new ExceptionResponse();
		 exceptionResponse.setErrorCode("Server_Error");
		 exceptionResponse.setErrorMessage(exception.getMessage());
		 return exceptionResponse;
	 }
 
}
