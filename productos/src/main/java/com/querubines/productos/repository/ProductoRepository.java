package com.querubines.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querubines.commons.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
