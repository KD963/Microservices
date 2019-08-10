package com.bridgelabz.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.user.response.Response;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handlerException(Exception exception) {

		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), null);
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> userHandlerException(RuntimeException runtimeexception) {
		Response response = new Response(HttpStatus.BAD_REQUEST.value(), runtimeexception.getMessage(), null);
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

	}
}
