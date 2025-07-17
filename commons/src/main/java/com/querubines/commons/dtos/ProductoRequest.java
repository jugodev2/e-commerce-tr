package com.querubines.commons.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;


public record ProductoRequest(
		 

	
		
		@NotBlank(message = "El nombre de producto no pueden ser nulos.")
		String nombre,
		
		@NotBlank(message = "La descripcion no puede ser Vacia o Nula.")
		String descripcion,
		
		@NotNull(message = "El precio no puede ser nulo")
		@DecimalMin(value = "0.01", message = "El precio debe de ser mayor a 0.")
		Float precio,
		
		@NotNull(message = "el stock no puede ser nulo.")
		@Min(value = 1, message = "El numero del stock  debe de ser mayor a 0.")
		int stock
		
		
		
	
		) {

}
