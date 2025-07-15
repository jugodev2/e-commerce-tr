package com.querubines.commons.dtos;

public record PedidoResponse(
		
		Long id, 
		String nombre,
		Double precio,
		int stock
		
		) {}
