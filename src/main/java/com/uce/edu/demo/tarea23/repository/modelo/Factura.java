package com.uce.edu.demo.tarea23.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "fact_id_seq")
	@SequenceGenerator(name = "fact_id_seq", sequenceName="fact_id_seq", allocationSize =1)
	@Column(name = "fact_id")
	private Integer id;
	
	@Column(name = "fact_descripcion")
	private String descripcion;
	
	@Column(name = "fact_fecha_factura")
	private LocalDateTime fechaFactura;
	
	@Column(name = "fact_costo")
	private BigDecimal costo;
	
	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;

	@Override
	public String toString() {
		return "Factura [id=" + id + ", descripcion=" + descripcion + ", fechaFactura=" + fechaFactura + ", costo="
				+ costo + ", cliente=" + cliente + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(LocalDateTime fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
