package com.querubines.commons.dtos;

public record ClienteResponse(
		Long id,
		String nombre,
		String apellido,
		String email,
		int telefono,
		String direccion
		) {

}
