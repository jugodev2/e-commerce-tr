package com.querubines.commons.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ProductoRequest(
		 

	
		
		@NotBlank(message = "El nombre de producto no pueden ser nulos.")
		String nombre,
		
		@NotBlank(message = "La descripcion no puede ser Vacia o Nula.")
		String descripcion,
		
		@NotBlank(message = "El precio no puede ser nulo")
		@Min(value = 1, message = "El precio debe de ser mayor a 1.")
		Double precio,
		
		@NotNull(message = "el stock  no puede ser nula.")
		@Min(value = 1, message = "El numero del stock  debe de ser minimo de 10.")
		int stock
		
		
		
	
		) {

}
