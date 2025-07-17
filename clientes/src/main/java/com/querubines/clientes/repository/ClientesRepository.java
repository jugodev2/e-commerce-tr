package com.querubines.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querubines.commons.models.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long> {

}
