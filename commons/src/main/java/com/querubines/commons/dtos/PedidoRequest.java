package com.querubines.commons.dtos;

import java.util.Date;
import java.util.List;

import com.querubines.commons.models.entities.ProductoPedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PedidoRequest(
		
		@NotNull(message = "Los puntos de poder no pueden ser nulos.")
		Long idCliente,
		
		@NotNull(message = "Los puntos de poder no pueden ser nulos.")
		@Min(value = 1, message = "El numero de telefono debe de ser minimo de 10.")
		Double total,
		
		@NotBlank(message = "La Fecha de Creacion no puede ser Vacia o Nula.")
		Date fechaCreacion,
		
		@NotBlank(message = "El estado no puede ser ")
		String estado,
		
		@NotNull(message = "La lista de productos no puede ser nula.")
		@Size(min = 1, message = "La lista de producto debe de tener almenos un dato.")
		List<ProductoPedido> productos
		
		) {

}
