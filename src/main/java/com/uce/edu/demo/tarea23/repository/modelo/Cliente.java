package com.uce.edu.demo.tarea23.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName="clie_id_seq", allocationSize =1)
	@Column(name = "clie_id")
	private Integer id;
	
	@Column(name = "clie_nombre")
	private String nombre;
	
	@Column(name = "clie_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "cliente", fetch=FetchType.EAGER)
	private List<Factura> facturas;


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", facturas=" + facturas + "]";
	}

	//Seter y Geter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
}
