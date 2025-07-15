package com.querubines.clientes.mappers;

import org.springframework.stereotype.Component;

import com.querubines.commons.dtos.ClienteRequest;
import com.querubines.commons.dtos.ClienteResponse;
import com.querubines.commons.mappers.CommonMapper;
import com.querubines.commons.models.entities.Cliente;

@Component
public class ClientesMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente> {
	
	

	@Override
	public ClienteResponse entityToResponse(Cliente entity) {
		if (entity == null) {
			return null;
		}
		return new ClienteResponse(
				entity.getId(),
				entity.getNombre(),
				entity.getApellido(),
				entity.getEmail(),
				entity.getTelefono(),
				entity.getDireccion()
		);
				
		
	}

	@Override
	public Cliente requestToEntity(ClienteRequest request) {
		if (request == null) {
			return null;
		}
		Cliente cliente = new Cliente();
		cliente.setNombre(request.nombre());
		cliente.setApellido(request.apellido());
		cliente.setEmail(request.email());
		cliente.setTelefono(request.telefono());
		cliente.setDireccion(request.direccion());
		return cliente;
	}

	
}

