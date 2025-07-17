package com.querubines.productos.mappers;
import org.springframework.stereotype.Component;

import com.querubines.commons.dtos.ProductoRequest;
import com.querubines.commons.dtos.ProductoResponse;
import com.querubines.commons.mappers.CommonMapper;
import com.querubines.commons.models.entities.Producto;
import com.querubines.productos.clients.NombreClients;

@Component
public class ProductoMappers extends CommonMapper<ProductoRequest, ProductoResponse, Producto>{

  

	@Override
	public ProductoResponse entityToResponse(Producto entity) {
		if(entity== null) {
		return null;
	}
	return new ProductoResponse (entity.getId(), 
			entity.getNombre(), 
			entity.getDescripcion(), 
			entity.getPrecio(), 
			entity.getStock());
			
	}

	@Override
	public Producto requestToEntity(ProductoRequest request) {
	if (request == null) {
		return null;
	}
	Producto producto = new Producto ();
	producto.setNombre(request.nombre());
	producto.setDescripcion(request.descripcion());
	producto.setPrecio(request.precio());
	producto.setStock(request.stock());
	return producto;
	}
}
