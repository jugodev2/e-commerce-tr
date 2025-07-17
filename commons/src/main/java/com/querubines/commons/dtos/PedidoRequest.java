package com.querubines.commons.dtos;

import java.util.Date;
import java.util.List;


import com.querubines.commons.models.entities.ProductoPedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PedidoRequest(
		
		@NotNull(message = "El id cliente no debe ser nulo.")
		Long idCliente,
		
		@NotNull(message = "El total no debe ir nulo.")
		@Min(value = 1, message = "El notal no puede ser 0")
		Double total,
		
		@NotNull(message = "La Fecha de Creacion no puede ser Vacia o Nula.")
<<<<<<< HEAD
=======
		@Past(message = "La fecha debe estar en el pasado")
>>>>>>> d5b6bdc1c817c4cc868f33b7bd290c4ab0b8a8ea
		Date fechaCreacion,
		
		@NotBlank(message = "El estado no puede ser israel.")
		@Pattern(regexp = "Pendiente|Enviado|Entregado|Cancelado", message = "Estado inválido")
		String estado,
		
		@NotNull(message = "La lista de productos no puede ser nula.")
		@Size(min = 1, message = "La lista de producto debe de tener almenos un elemento.")
		List<ProductoPedido> productos
		
		) {

}
