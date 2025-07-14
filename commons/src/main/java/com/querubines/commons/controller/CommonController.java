package com.querubines.commons.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.querubines.commons.services.CommonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Validated
public class CommonController<RQ, RS, S extends CommonService<RQ, RS>> {

	protected S service;

	public CommonController(S service) {
		this.service = service;
	}
	@GetMapping
	  public ResponseEntity<List<RS>> listar(){
	    List<RS> response = service.listar();
	    return ResponseEntity.ok(response);
	  }
	
	@GetMapping("/{id}")
	  public ResponseEntity<RS> obtenerPorId(@PathVariable @Min(value = 1, message = "El ID debe ser positivo") Long id){
	    return ResponseEntity.ok(service.obtenerPorId(id)
	        .orElseThrow(NoSuchElementException::new));
	  }
	
	@PostMapping
	public ResponseEntity<RS> insertar(@Valid @RequestBody RQ request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(request));
	}
	
	@PutMapping("/{id}")
	  public ResponseEntity<RS> actualizar(@Valid @RequestBody RQ request, @PathVariable
	      @Min(value = 1, message = "El ID debe ser positivo")Long id){
	    return ResponseEntity.ok(service.actualizar(request, id));
	  }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RS> eliminar(@PathVariable @Min(value = 1, message = "EL ID debe ser positivo.") Long id) {
		return ResponseEntity.ok(service.eliminar(id));
	}
	
	
}
