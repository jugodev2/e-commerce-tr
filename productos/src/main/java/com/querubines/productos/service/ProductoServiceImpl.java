package com.querubines.productos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querubines.commons.dtos.ProductoRequest;
import com.querubines.commons.dtos.ProductoResponse;
import com.querubines.commons.models.entities.Producto;
import com.querubines.productos.mappers.ProductoMappers;
import com.querubines.productos.repository.ProductoRepository;
import com.thoughtworks.xstream.mapper.Mapper;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repository;
	private ProductoMappers mapper;
	
	
	public ProductoServiceImpl(ProductoRepository repository, ProductoMappers mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	@Override
	public List<ProductoResponse> listar() {
		List<ProductoResponse>productos = new ArrayList<>();
		repository.findAll().forEach(producto->{
			productos.add(mapper.entityToResponse(producto));
		});
		return productos;
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<ProductoResponse> obtenerPorId(Long id) {
		Producto producto = repository.findById(id).orElseThrow(NoSuchElementException :: new);
		return Optional.of(mapper.entityToResponse(producto));
	}
	@Override
	public ProductoResponse insertar(ProductoRequest request) {
		Producto producto = mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(producto));
	}
	@Override
	public ProductoResponse actualizar(ProductoRequest request, Long id) {
	Producto producto = repository.findById(id).orElseThrow(NoSuchElementException :: new);
	producto.setNombre(request.nombre());
		return mapper.entityToResponse(repository.save(producto));
	}
	@Override
	public ProductoResponse eliminar(Long id) {
		Producto producto = repository.findById(id).orElseThrow(NoSuchElementException :: new);
		
		repository.deleteById(id);
		return mapper.entityToResponse(producto);
	}
	
	
	
	
	

}
