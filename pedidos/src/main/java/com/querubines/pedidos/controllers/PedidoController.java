package com.querubines.pedidos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.querubines.commons.controller.CommonController;
import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.pedidos.services.PedidosService;


@RestController
public class PedidoController extends CommonController<PedidoRequest, PedidoResponse, PedidosService >{

	public PedidoController(PedidosService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}
