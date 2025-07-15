package com.querubines.commons.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
		
		@NotBlank (message = "El nombre no puede ir vacio ni null")
		String nombre,
		
		@NotNull(message = "La Descripcion no puede ir vacio ni null")
		String descripcion,
		
		@NotNull(message = "El precio no puede ser nulo.")
		@Min(value = 1, message = "El precio debe ser mayor o igual a 1.")
		double precio,

		@NotNull(message = "El stock no puede ser nulo.")
		@Min(value = 0, message = "El stock no puede ser negativo.")
		int stock

		
		) {

}
