package com.querubines.pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.querubines.commons.dtos.ProductoResponse;

@FeignClient(name = "productos")
public interface ProductoClient {
	
	@GetMapping("/id-producto/{id}")
	ProductoResponse getProducto(@PathVariable Long id);

}
