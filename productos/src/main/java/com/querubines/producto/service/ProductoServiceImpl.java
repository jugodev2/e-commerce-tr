package com.querubines.producto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querubines.commons.dtos.ProductoRequest;
import com.querubines.commons.dtos.ProductoResponse;
import com.querubines.commons.models.entities.Producto;
import com.querubines.producto.mappers.ProductoMappers;
import com.querubines.productos.repository.ProductoRepository;
import com.thoughtworks.xstream.mapper.Mapper;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repository;
	private ProductoMappers mapper;
	
	
	
	public ProductoServiceImpl(ProductoRepository repository, ProductoMappers mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	@Override
	public List<ProductoResponse> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<ProductoResponse> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public ProductoResponse insertar(ProductoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductoResponse actualizar(ProductoRequest request, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductoResponse eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
