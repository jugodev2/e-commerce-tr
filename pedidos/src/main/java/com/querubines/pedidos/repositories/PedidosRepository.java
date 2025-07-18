package com.querubines.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
>>>>>>> d5b6bdc1c817c4cc868f33b7bd290c4ab0b8a8ea
=======
>>>>>>> 2a5d13ea113a341f8e05777d5a3529b84259d7d1

import com.querubines.commons.models.entities.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {
	
<<<<<<< HEAD
	@Query("SELECT p FROM Pedido p WHERE p.idCliente = :clienteId")
	boolean existsByClienteId(@Param("clienteId") Long clienteId);

=======
	
>>>>>>> d5b6bdc1c817c4cc868f33b7bd290c4ab0b8a8ea
}
