package com.querubines.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_SEQ")
	@SequenceGenerator(name = "PRODUCTO_SEQ", sequenceName = "PRODUCTO_SEQ", allocationSize = 1)
	@Column(name = "ID_PRODUCTO")
	private Long id;
	
	@Column (name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column (name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column (name = "PRECIO", nullable = false, unique = true)
	private Double precio;
	
	@Column (name = "STOCK", nullable = false, unique = true)
	private int stock;

}
