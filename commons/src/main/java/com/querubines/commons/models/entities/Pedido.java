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
	@CollectionTable(name = "PEDIDO_PRODUCTOS", joinColumns = @JoinColumn(name = "ID_PEDIDO"))
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
	
	
	
	

}
