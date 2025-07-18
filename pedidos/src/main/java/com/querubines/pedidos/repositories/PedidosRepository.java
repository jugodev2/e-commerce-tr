package com.querubines.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querubines.commons.models.entities.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
	
	
}
