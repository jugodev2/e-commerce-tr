package com.querubines.pedidos.mappers;

import java.util.List;

import com.querubines.commons.dtos.ClienteResponse;
import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.commons.mappers.CommonMapper;
import com.querubines.commons.models.entities.Pedido;
import com.querubines.commons.models.entities.ProductoPedido;
import com.querubines.pedidos.clients.ClienteClient;

public class PedidosMapper extends CommonMapper<PedidoRequest, PedidoResponse, Pedido> {
	
	private ClienteClient client;

	public PedidosMapper(ClienteClient client) {
		this.client = client;
	}

	@Override
	protected PedidoResponse entityToResponse(Pedido entity) {
		if (entity == null) {
			return null;
		}
		ClienteResponse cliente = null;
		
		if (entity.getIdCliente()!=null) {
			cliente = client.getCliente(entity.getIdCliente());
		}
		
		List<ProductoPedido> productos = null;
		
		return new PedidoResponse(
				entity.getId(),
				cliente.nombre(),
				entity.getTotal(),
				entity.getFechaCreacion(),
				entity.getEstado(),
				productos
				);
				
	}

	@Override
	protected Pedido requestToEntity(PedidoRequest request) {
		if (request == null) {
			return null;
		}
		
		Pedido pedido = new Pedido();
		pedido.setIdCliente(request.idCliente());
		pedido.setTotal(request.total());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setEstado(request.estado());
		pedido.setProductos(request.productos());
		
		return null;
	}

}
