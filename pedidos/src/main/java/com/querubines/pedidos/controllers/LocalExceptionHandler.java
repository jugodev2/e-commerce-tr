package com.querubines.pedidos.controllers;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException;

@RestController
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LocalExceptionHandler {

	private static final Logger logger = Logger.getLogger(LocalExceptionHandler.class.getName());
	
	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity<Map<String, Object>> feignExceptionNotFound(FeignException.NotFound e){
		logger.log(Level.SEVERE, "ERROR al comunicarse con el cliente FEIGN");
		return ResponseEntity.badRequest().body(Map.of(
				"code", 404,
				"response", "El recurso solicitado no fue encontrado."
				));
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, Object>> feignException(FeignException.NotFound e){
		logger.log(Level.SEVERE, "ERROR al comunicarse con el cliente FEIGN: " +
				(e.getCause() != null ? e.getCause() : e.getMessage())
				);
		return ResponseEntity.badRequest().body(Map.of(
				"code", 500,
				"response", "ERROR al comunicarse con el cliente FEIGN:" + e.getMessage()
				));
	}
	
}
