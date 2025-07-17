package com.querubines.pedidos.controllers;

import com.querubines.commons.controller.CommonController;
import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.pedidos.services.PedidosService;

public class PedidosController extends CommonController<PedidoRequest, PedidoResponse, PedidosService> {

	public PedidosController(PedidosService service) {
		super(service);
	}

	// Aquí puedes agregar métodos específicos para manejar pedidos si es necesario
	// Por ejemplo, métodos para buscar pedidos por cliente, etc.
	
	// Ejemplo:
	// @GetMapping("/cliente/{clienteId}")
	// public List<PedidoResponse> getPedidosByCliente(@PathVariable Long clienteId) {
	// 	return service.getPedidosByCliente(clienteId);
	// }

}
