package com.querubines.commons.models.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
	@SequenceGenerator(name = "PEDIDO_SEQ", sequenceName = "PEDIDO_SEQ", allocationSize = 1)
	@Column(name = "ID_PEDIDO")
	private Long id;
	
	@Column (name = "ID_CLIENTE", nullable = false)
	private Long idCliente;
	
	@Column (name = "TOTAL", nullable = false)
	private Double total;
	
	@Column (name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;
	
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ElementCollection
	@CollectionTable(name = "PEDIDO_PRODUCTO", joinColumns = @JoinColumn(name = "ID_PEDIDO"))
	private List<ProductoPedido> productos;

	public Pedido(Long id, Long idCliente, Double total, Date fechaCreacion, String estado,
			List<ProductoPedido> productos) {
		this.id = id;
		this.idCliente = idCliente;
		this.total = total;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.productos = productos;
	}
	
	public Pedido() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ProductoPedido> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoPedido> productos) {
		this.productos = productos;
	}
	
	
	
	

}
