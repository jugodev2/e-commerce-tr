package com.querubines.clientes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.querubines.clientes.clients.PedidosClient;
import com.querubines.clientes.mappers.ClientesMapper;
import com.querubines.clientes.repository.ClientesRepository;
import com.querubines.commons.dtos.ClienteRequest;
import com.querubines.commons.dtos.ClienteResponse;
import com.querubines.commons.models.entities.Cliente;

@Service
public class ClientesServiceImpl implements ClientesService {
	private final ClientesRepository repository;
	private final ClientesMapper mapper;
	private final PedidosClient pedidosClient;
	
	


	public ClientesServiceImpl(ClientesRepository repository, ClientesMapper mapper, PedidosClient pedidosClient) {
		super();
		this.repository = repository;
		this.mapper = mapper;
		this.pedidosClient = pedidosClient;
	}

	@Override
	public List<ClienteResponse> listar() {
		List<ClienteResponse> clientes = new ArrayList<>();
		repository.findAll().forEach(cliente -> {
			clientes.add( mapper.entityToResponse(cliente));
		});
		return clientes;
		
	}

	@Override
	public Optional<ClienteResponse> obtenerPorId(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(cliente));
	}

	@Override
	public ClienteResponse insertar(ClienteRequest request) {
		Cliente cliente = mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(cliente));
	}

	@Override
	public ClienteResponse actualizar(ClienteRequest request, Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(NoSuchElementException::new);
		cliente.setNombre(request.nombre());
		cliente.setApellido(request.apellido());
		cliente.setEmail(request.email());
		cliente.setTelefono(request.telefono());
		cliente.setDireccion(request.direccion());
		
		return mapper.entityToResponse(repository.save(cliente));
	}

	@Override
	public ClienteResponse eliminar(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(NoSuchElementException::new);
		boolean tienePedidos = pedidosClient.clienteTienePedidos(id);
		if (tienePedidos) {
			throw new IllegalStateException("El cliente no puede ser eliminado porque tiene pedidos asociados.");
		} else {
			repository.delete(cliente);
			return mapper.entityToResponse(cliente);
		}
	}
	

	
}
