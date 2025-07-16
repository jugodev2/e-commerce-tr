package com.querubines.producto.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock")
public interface StockClients {
	
	@GetMapping("/id-producto/{id}")
	boolean productoIsPresent(@PathVariable Long id);

}
