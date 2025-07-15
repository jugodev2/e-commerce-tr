package com.querubines.clientes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.querubines.clientes.repository.ClientesRepository;
import com.querubines.commons.dtos.ClienteRequest;
import com.querubines.commons.dtos.ClienteResponse;

@Service
public class ClientesImpl implements ClientesService {
	private final ClientesRepository repository;
	
	

	public ClientesImpl(ClientesRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<ClienteResponse> listar() {
		List<ClienteResponse> clientes = new ArrayList<>();
		repository.findAll().forEach(cliente -> {
			clientes.add();
		});
		
	}

	@Override
	public Optional<ClienteResponse> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ClienteResponse insertar(ClienteRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse actualizar(ClienteRequest request, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
