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
@Table(name = "libro2")
public class Libro2 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "libr2_id_seq")
	@SequenceGenerator(name = "libr2_id_seq", sequenceName="libr2_id_seq", allocationSize =1)
	@Column(name = "libr2_id")
	private Integer id;
	
	@Column(name = "libr2_titulo")
	private String titulo;
	
	@Column(name = "libr2_cantidad_paginas")
	private Integer cantidad_paginas;

	@OneToMany(mappedBy="libro2")
	private List<LibroAutor2> libroAutor2;

	
	
	@Override
	public String toString() {
		return "Libro2 [id=" + id + ", titulo=" + titulo + ", cantidad_paginas=" + cantidad_paginas + ", libroAutor2="
				+ libroAutor2 + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidad_paginas() {
		return cantidad_paginas;
	}

	public void setCantidad_paginas(Integer cantidad_paginas) {
		this.cantidad_paginas = cantidad_paginas;
	}

	public List<LibroAutor2> getLibroAutor2() {
		return libroAutor2;
	}

	public void setLibroAutor2(List<LibroAutor2> libroAutor2) {
		this.libroAutor2 = libroAutor2;
	}
	
	
}