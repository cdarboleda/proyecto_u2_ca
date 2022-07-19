package com.uce.edu.demo.tarea13.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable{
	private String nombre;
	private String apellido;
	private String carrera;
	
	public EstudianteSencillo(String nombre, String apellido, String carrera) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.carrera = carrera;
	}
	
	public EstudianteSencillo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera + "]";
	}
	//SET Y GET
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
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
}
