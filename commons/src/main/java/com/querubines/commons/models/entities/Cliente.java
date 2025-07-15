package com.querubines.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
	@Column(name = "ID_CLIENTE")
	private Long id;
	
	@Column (name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column (name = "APELLIDO", nullable = false)
	private String apellido;
	
	@Column (name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column (name = "TELEFONO", nullable = false, unique = true)
	private int telefono;
	
	@Column (name = "DIRECCION", nullable = false)
	private String direccion;

}
