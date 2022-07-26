package com.uce.edu.demo.tarea24.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor2")
public class Autor2 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "auto2_id_seq")
	@SequenceGenerator(name = "auto2_id_seq", sequenceName="auto2_id_seq", allocationSize =1)
	@Column(name = "auto2_id")
	private Integer id;
	
	@Column(name = "auto2_nombre")
	private String nombre;
	
	//No principal
	@OneToMany(mappedBy="autor2")
	private List<LibroAutor2> libroAutor2;

	
	@Override
	public String toString() {
		return "Autor2 [id=" + id + ", nombre=" + nombre + ", libroAutor2=" + libroAutor2 + "]";
	}

	//SET Y GET
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

	public List<LibroAutor2> getLibroAutor2() {
		return libroAutor2;
	}

	public void setLibroAutor2(List<LibroAutor2> libroAutor2) {
		this.libroAutor2 = libroAutor2;
	}
	
	
	
}	