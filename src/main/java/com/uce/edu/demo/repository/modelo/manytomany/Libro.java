package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "libr_id_seq")
	@SequenceGenerator(name = "libr_id_seq", sequenceName="libr_id_seq", allocationSize =1)
	@Column(name = "libr_id")
	private Integer id;
	
	@Column(name = "libr_titulo")
	private String titulo;
	
	@Column(name = "libr_cantidad_paginas")
	private Integer cantidad_paginas;

	//Escogida como principal
	@ManyToMany(cascade = CascadeType.ALL)//joinColumns = (columna fk de la tabla principal), inverseJoinColumns = (columna fk de la tabla No principal)
	@JoinTable(name = "libro_autor", joinColumns = @JoinColumn(name = "liau_id_libro"), inverseJoinColumns = @JoinColumn(name = "liau_id_autor"))
	private Set<Autor> autores;
	
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

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	
	
}
