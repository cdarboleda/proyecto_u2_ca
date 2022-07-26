/**
 * 
 */
package com.uce.edu.demo.tarea24.repository.modelo;

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
@Table(name = "libro2_autor2")
public class LibroAutor2 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "liau_id_seq")
	@SequenceGenerator(name = "liau_id_seq", sequenceName="liau_id_seq", allocationSize =1)
	@Column(name = "liau_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "autor2_id")
	private Autor2 autor2;
	
	@ManyToOne
	@JoinColumn(name = "libro2_id")
	private Libro2 libro2;
	
	@Override
	public String toString() {
		return "LibroAutor2 [id=" + id + ", autor2=" + autor2 + ", libro2=" + libro2 + "]";
	}

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Autor2 getAutor2() {
		return autor2;
	}

	public void setAutor2(Autor2 autor2) {
		this.autor2 = autor2;
	}

	public Libro2 getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro2 libro2) {
		this.libro2 = libro2;
	}
	
	
}
