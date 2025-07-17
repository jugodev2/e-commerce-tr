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
	private Long telefono;
	
	@Column (name = "DIRECCION", nullable = false)
	private String direccion;

	public Cliente(Long id, String nombre, String apellido, String email, Long telefono, String direccion) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	

	public Cliente() {
	
		
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	


}
