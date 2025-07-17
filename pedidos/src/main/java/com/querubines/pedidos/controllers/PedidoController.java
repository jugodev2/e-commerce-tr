package com.querubines.pedidos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> d5b6bdc1c817c4cc868f33b7bd290c4ab0b8a8ea
import org.springframework.web.bind.annotation.RestController;

import com.querubines.commons.controller.CommonController;
import com.querubines.commons.dtos.PedidoRequest;
import com.querubines.commons.dtos.PedidoResponse;
import com.querubines.pedidos.services.PedidosService;


@RestController
public class PedidoController extends CommonController<PedidoRequest, PedidoResponse, PedidosService >{

	public PedidoController(PedidosService service) {
		super(service);
	}
	
	@GetMapping("/id-clientes/{id}")
	public ResponseEntity<Boolean> existeCliente(@PathVariable Long id) {
		boolean existe = service.existeCliente(id);
		return ResponseEntity.ok(existe);
	}



}
