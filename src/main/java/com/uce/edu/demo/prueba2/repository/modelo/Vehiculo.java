package com.uce.edu.demo.prueba2.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	@Id
	@Column(name ="vehi_placa")
	private String placa;
	@Column(name ="vehi_marca")
	private String marca;
	@Column(name ="vehi_tipo")
	private String tipo;
	@Column(name ="vehi_precio")
	private BigDecimal precio;
	
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", tipo=" + tipo + ", placa=" + placa + ", precio=" + precio + "]";
	}
	
	//SET Y GET
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
}
