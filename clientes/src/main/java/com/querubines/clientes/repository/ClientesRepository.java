package com.querubines.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querubines.commons.models.entities.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

}
