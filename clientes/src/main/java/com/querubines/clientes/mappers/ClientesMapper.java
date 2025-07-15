package com.querubines.clientes.mappers;

import com.querubines.commons.dtos.ClienteRequest;
import com.querubines.commons.dtos.ClienteResponse;
import com.querubines.commons.mappers.CommonMapper;
import com.querubines.commons.models.entities.Cliente;

public class ClientesMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente> {

	@Override
	protected ClienteResponse entityToResponse(Cliente entity) {
		if (entity == null) {
			return null;
		}
		return new ClienteResponse(
				
		);
	}

	@Override
	protected Cliente requestToEntity(ClienteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

