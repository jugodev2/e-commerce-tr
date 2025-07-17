package com.querubines.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querubines.commons.models.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	

}
