package com.querubines.clientes.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.querubines.clientes.services.ClientesService;
import com.querubines.commons.controller.CommonController;
import com.querubines.commons.dtos.ClienteRequest;
import com.querubines.commons.dtos.ClienteResponse;

@Validated
@RestController
public class ClientesController extends CommonController<ClienteRequest, ClienteResponse, ClientesService> {

	public ClientesController(ClientesService service) {
		super(service);
	}
	
}
