package com.querubines.pedidos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;


import com.querubines.commons.models.entities.Pedido;


@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {
	
	
	@Query("SELECT COUNT(p) > 0 FROM Pedido p WHERE p.idCliente = :clienteId")
	boolean existsByClienteId(@Param("clienteId") Long clienteId);
	
	
	
	List<Pedido> findByIdCliente(Long idCliente);

}
