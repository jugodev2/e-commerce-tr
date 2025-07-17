package com.querubines.pedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.commons.models.entities.Pedido;
import com.querubines.pedidos.clients.ClienteClient;
import com.querubines.pedidos.clients.ProductoClient;
import com.querubines.pedidos.mappers.PedidosMapper;
import com.querubines.pedidos.repositories.PedidosRepository;

@Service
public class PedidosServicesImpl implements PedidosService {
	
	private PedidosRepository repository;
	private ClienteClient clienteClient;
	private ProductoClient productoClient;
	private PedidosMapper mapper;

	public PedidosServicesImpl(PedidosRepository repository, ClienteClient clienteClient, ProductoClient productoClient,
			PedidosMapper mapper) {
		this.repository = repository;
		this.clienteClient = clienteClient;
		this.productoClient = productoClient;
		this.mapper = mapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidoResponse> listar() {
		List<PedidoResponse> pedidos = new ArrayList<>();
		repository.findAll().forEach(pedido -> {
			pedidos.add(mapper.entityToResponse(pedido));
		});
		return pedidos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PedidoResponse> obtenerPorId(Long id) {
		Pedido pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(pedido));
	}

	@Override
	public PedidoResponse insertar(PedidoRequest request) {
		Pedido pedido = mapper.requestToEntity(request);
		clienteClient.getCliente(request.idCliente());
	
		return mapper.entityToResponse(repository.save(pedido));
	}

	@Override
	public PedidoResponse actualizar(PedidoRequest request, Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		if (pedido.isPresent()) {
			Pedido pedidoDB = pedido.get();
			pedidoDB.setTotal(request.total());
			pedidoDB.setEstado(request.estado());
			pedidoDB.setFechaCreacion(request.fechaCreacion());
			pedidoDB.setProductos(request.productos());
			return mapper.entityToResponse(repository.save(pedidoDB));
		}
		return null;
	}

	@Override
	public PedidoResponse eliminar(Long id) {
		Pedido pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		repository.deleteById(id);
		return mapper.entityToResponse(pedido);
	}





}
