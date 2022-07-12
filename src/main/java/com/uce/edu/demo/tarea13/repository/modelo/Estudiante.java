package com.uce.edu.demo.tarea13.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name ="Estudiante.buscarPorEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :datoEdad")
@NamedQuery(name = "Estudiante.buscarPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre")
@NamedQuery(name = "Estudiante.buscarPorCarrera", query = "SELECT e FROM Estudiante e WHERE e.carrera = :datoCarrera")
@NamedQuery(name = "Estudiante.buscarTodos", query = "SELECT e FROM Estudiante e ORDER BY e.apellido ASC")
public class Estudiante {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="carrera")
	private String carrera;
	
	@Column(name="edad")
	private int edad;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera
				+ ", edad=" + edad + "]";
	}

	// SET Y GET
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
