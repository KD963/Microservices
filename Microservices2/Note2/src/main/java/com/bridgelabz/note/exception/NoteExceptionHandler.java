package com.bridgelabz.note.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.note.response.Response;



@ControllerAdvice
public class NoteExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handlerException( Exception exception) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),  null);
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoteException.class)
	public ResponseEntity<Response> noteHandlerException(RuntimeException runtimeException) {
		Response response = new Response(HttpStatus.BAD_REQUEST.value(), runtimeException.getMessage(), null);
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

	}
}
