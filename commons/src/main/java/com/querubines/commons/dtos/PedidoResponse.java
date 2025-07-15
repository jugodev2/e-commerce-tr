package com.querubines.commons.dtos;

import java.util.List;

import com.querubines.commons.models.entities.ProductoPedido;

public record PedidoResponse(
		
		Long idPedido,
		Long idCliente,
		Double total,
		String fechaCreacion,
		String estado,
		List<ProductoPedido> productos
		
		) {
	
}
