package com.querubines.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
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
	private Float precio;
	
	@Column (name = "STOCK", nullable = false, unique = true)
	private int stock;

	
	
	public Producto() {
		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
