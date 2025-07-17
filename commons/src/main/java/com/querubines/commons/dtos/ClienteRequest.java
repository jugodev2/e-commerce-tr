package com.querubines.commons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
		
		@NotBlank(message = "El nombre no puede ir vacio ni null.")
		String nombre,
		
		@NotBlank(message = "El apellido no puede ir vacio ni null.")
		String apellido,
		
		@NotBlank(message = "El email no puede ir vacio ni null.")
		@Email(message = "El formato del email no es válido")
		String email,
		
		@NotNull(message = "Los puntos de poder no pueden ser nulos.")
		@Min(value = 1000000000L, message = "El numero de telefono debe de tener 10 digitos")
		@Max(value = 9999999999L, message = "El numero de telefono debe de tener 10 digitos")
		Long telefono,
		
		@NotBlank(message = "La direccion no puede ir vacio ni null.")
		@Size(max = 100, message = "La direccion no puede exceder los 100 caracteres.")
		String direccion
		) {

}
