package com.querubines.clientes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedidos")
public interface PedidosClient {
	
	@GetMapping("/id-clientes/{id}")
	boolean clienteTienePedidos(@PathVariable Long id);
		

	
}
