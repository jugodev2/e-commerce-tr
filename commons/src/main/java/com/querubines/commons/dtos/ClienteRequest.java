package com.querubines.commons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
		
		@NotBlank(message = "El nombre no puede ir vacio ni null.")
		String nombre,
		
		@NotBlank(message = "El apellido no puede ir vacio ni null.")
		String apellido,
		
		@NotBlank(message = "El email no puede ir vacio ni null.")
		@Email(message = "El formato del email no es válido")
		String email,
		
		@NotNull(message = "Los puntos de poder no pueden ser nulos.")
		@Min(value = 10, message = "El numero de telefono debe de ser minimo de 10.")
		@Max(value = 10, message = "El numero de telefono debe de ser maximo de 10.")
		int telefono,
		
		@NotBlank(message = "La direccion no puede ir vacio ni null.")
		@Max(value = 100, message = "La direccion no debe ser mayor a 100 caracteres.")
		String direccion
		) {

}
