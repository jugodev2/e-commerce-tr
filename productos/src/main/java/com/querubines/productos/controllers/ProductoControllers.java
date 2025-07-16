package com.querubines.productos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.querubines.commons.controller.CommonController;
import com.querubines.commons.dtos.ProductoRequest;
import com.querubines.commons.dtos.ProductoResponse;
import com.querubines.producto.service.ProductoService;

@RestController
public class ProductoControllers  extends CommonController<ProductoRequest, ProductoResponse, ProductoService >{

	public ProductoControllers(ProductoService service) {
		super(service);
		// TODO Auto-generated constructor stub
				
		}

}
