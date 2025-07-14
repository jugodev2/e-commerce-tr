package com.querubines.commons.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.querubines.commons.exceptions.EntidadRelacionadaException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {
	
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity< Map<String, Object> > dataIntegrityViolationException(DataIntegrityViolationException e) {
		logger.log(Level.SEVERE, "Error en la integridad de los datos: " + 
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 400,
				"response", "Error en la integridad de los datos: " + e.getMessage()
		));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity< Map<String, Object> > constraintViolationException(ConstraintViolationException e) {
		logger.log(Level.WARNING, "Violación de restricción: " + 
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 400,
				"response", "Violación de restricción: " + e.getMessage()
		));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity< Map<String, Object> > noSuchElementException(NoSuchElementException e) {
		logger.log(Level.INFO, "No se encontró información asociada con el identificador ingresado.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
				"code", 404,
				"response", "No se encontró información asociada con el identificador ingresado, verifica que sea correcto"
		));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException e) {
		logger.log(Level.WARNING, "Error de validación de argumentos: " + e.getMessage());

		String mensaje = e.getBindingResult().getFieldErrors().stream()
			.map(err -> err.getField() + ": " + err.getDefaultMessage())
			.findFirst()
			.orElse("Error de validación en los datos enviados.");

		return ResponseEntity.badRequest().body(Map.of(
				"code", 400,
				"response", mensaje
		));
	}
	
	@ExceptionHandler(EntidadRelacionadaException.class)
    public ResponseEntity<Map<String, Object>> entidadRelacionadaException(EntidadRelacionadaException ex) {
		Map<String, Object> respuesta = new HashMap<>();
	    respuesta.put("code", HttpStatus.CONFLICT.value());
	    respuesta.put("response", ex.getMessage());
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity< Map<String, Object> > handleGeneralErrors(Exception e) {
		logger.log(Level.SEVERE, "Error interno del servidor: " + 
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
				"code", 500,
				"response", "Error interno del servidor: " + (e.getCause() != null ? e.getCause() : e.getMessage())
		));
	}
}
