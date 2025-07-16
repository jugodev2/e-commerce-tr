package com.querubines.pedidos.services;

import java.util.List;
import java.util.Optional;

import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.pedidos.clients.ClienteClient;
import com.querubines.pedidos.clients.ProductoClient;
import com.querubines.pedidos.mappers.PedidosMapper;
import com.querubines.pedidos.repositories.PedidosRepository;

public class PedidosServicesImpl implements PedidosService {
	
	private PedidosRepository repository;
	private ClienteClient clienteClient;
	private ProductoClient productoClient;
	private PedidosMapper mapper;

	public PedidosServicesImpl(PedidosRepository repository, ClienteClient clienteClient, ProductoClient productoClient,
			PedidosMapper mapper) {
		super();
		this.repository = repository;
		this.clienteClient = clienteClient;
		this.productoClient = productoClient;
		this.mapper = mapper;
	}

	@Override
	public List<PedidoResponse> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PedidoResponse> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public PedidoResponse insertar(PedidoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoResponse actualizar(PedidoRequest request, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoResponse eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
