package com.querubines.pedidos.mappers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.querubines.commons.dtos.ClienteResponse;
import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.commons.mappers.CommonMapper;
import com.querubines.commons.models.entities.Cliente;
import com.querubines.commons.models.entities.Pedido;
import com.querubines.commons.models.entities.ProductoPedido;
import com.querubines.pedidos.clients.ClienteClient;
import com.querubines.pedidos.repositories.PedidosRepository;

@Component
public class PedidosMapper extends CommonMapper<PedidoRequest, PedidoResponse, Pedido> {
	
	private ClienteClient client;

	public PedidosMapper(ClienteClient client) {
		this.client = client;
	}

	@Override
	public PedidoResponse entityToResponse(Pedido entity) {
		if (entity == null) {
			return null;
		}
		
		String nombre = null;
		
		if (entity.getIdCliente() != null) {
			ClienteResponse opt = client.getCliente(entity.getIdCliente());
			nombre = opt.nombre();
		}
		
		List<ProductoPedido> productos = null;
		
		return new PedidoResponse(
				entity.getId(),
				nombre,
				entity.getTotal(),
				entity.getFechaCreacion(),
				entity.getEstado(),
				productos
				);
				
	}

	@Override
	public Pedido requestToEntity(PedidoRequest request) {
		if (request == null) {
			return null;
		}
		
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		pedido.setIdCliente(cliente.getId());;
		pedido.setTotal(request.total());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setEstado(request.estado());
		pedido.setProductos(request.productos());
		
		return pedido;
	}

}
