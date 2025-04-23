package com.tfg.config;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tfg.dto.ApiMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiMessage>handleValidationException(MethodArgumentNotValidException ex){
		String errorMensaje=Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
		return ResponseEntity.badRequest().body(new ApiMessage(errorMensaje ));
}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiMessage>handleGeneralException(Exception ex){
		String errorMensaje=ex.getMessage();
		return ResponseEntity.internalServerError().body(new ApiMessage(errorMensaje ));
	}
}