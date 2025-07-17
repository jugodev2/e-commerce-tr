package com.querubines.productos.controllers;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.querubines.commons.controller.GlobalExceptionHandler;

import feign.FeignException;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LocalExceptionHandler extends GlobalExceptionHandler{
	
	private static final Logger logger = Logger.getLogger(LocalExceptionHandler.class.getName());
	
	@ExceptionHandler (FeignException.NotFound.class)
	public ResponseEntity<Map<String, Object> > feignExceptionNotFound(FeignException.NotFound e){
		logger.log(Level.SEVERE, "Error al comunicarse con el cliente Feing ");
		return ResponseEntity.badRequest().body(Map.of(
				"code", 404,
				"response", "El producto no fue encontrado"
				));
	}
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, Object> > feignException(FeignException e){
		logger.log(Level.SEVERE, "Error al comunicarse con el cliente Feing:" +
	(e.getCause() !=null? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 500,
				"response", "Error al comunicarse con el cliente Feing:" + e.getMessage()
				));
}
	}
