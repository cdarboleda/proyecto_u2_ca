package com.uce.edu.demo.tarea13.repository.modelo;

public class EstudianteContadorCarrera {
	private String carrera;
	private Long cantidad;
	
	public EstudianteContadorCarrera(String carrera, Long cantidad) {
		super();
		this.carrera = carrera;
		this.cantidad = cantidad;
	}
	
	public EstudianteContadorCarrera() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "EstudianteContadorCarrera [carrera=" + carrera + ", cantidad=" + cantidad + "]";
	}
	//SET Y GET
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
