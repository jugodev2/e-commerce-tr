package com.querubines.pedidos.mappers;

import java.util.ArrayList;
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
import com.querubines.pedidos.clients.ProductoClient;
import com.querubines.pedidos.repositories.PedidosRepository;

@Component
public class PedidosMapper extends CommonMapper<PedidoRequest, PedidoResponse, Pedido> {
	
	private ClienteClient client;
	private ProductoClient productoClient;

	public PedidosMapper(ClienteClient client, ProductoClient productoClient) {

		this.client = client;
		this.productoClient = productoClient;
	}

	@Override
	public PedidoResponse entityToResponse(Pedido entity) {
		if (entity == null) {
			return null;
		}
		
		Long idCliente = null;
		
		if (entity.getIdCliente() != null) {
			ClienteResponse opt = client.getCliente(entity.getIdCliente());
			idCliente = opt.id();
		}
		
		List<ProductoPedido> productos = entity.getProductos();
		for (int i = 0; i < productos.size(); i++) {
			productoClient.getProducto(productos.get(i).getIdProducto());
		}
		
		return new PedidoResponse(
				entity.getId(),
				idCliente,
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
		Pedido pedido = new Pedido();
		pedido.setIdCliente(request.idCliente());;
		pedido.setTotal(request.total());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setEstado(request.estado());
		pedido.setProductos(request.productos());	
		return pedido;
	}

}
