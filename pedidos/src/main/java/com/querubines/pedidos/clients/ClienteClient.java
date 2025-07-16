package com.querubines.pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.querubines.commons.dtos.ClienteResponse;

@FeignClient(name = "clientes")
public interface ClienteClient {
	
	@GetMapping("/{id}")
	ClienteResponse getCliente(@PathVariable Long id);
	
	
}
