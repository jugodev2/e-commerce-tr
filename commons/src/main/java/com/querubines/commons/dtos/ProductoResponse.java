package com.querubines.commons.dtos;

public record ProductoResponse(
		
				Long id, 
				String nombre, 
				String descripcion, 
				Float precio, 
				int stock
				
		) {

}
