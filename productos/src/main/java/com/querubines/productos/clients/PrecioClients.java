package com.querubines.productos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "precio")
public interface PrecioClients {
	
	@GetMapping("/id-producto/{id}")
	boolean productoIsPresent(@PathVariable Long id); 
}


