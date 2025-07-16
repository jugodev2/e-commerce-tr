package com.querubines.commons.dtos;

public record ProductoResponse(
		
				Long id, 
				String nombre, 
				String descripcion, 
				Double precio, 
				int stock
				
		) {

}
