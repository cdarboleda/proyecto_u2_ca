package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

public interface ILibroRepository {
	public void insertar(Libro libro);
	public Libro buscarPorId(Libro libro);
	public void actualizar(Libro libro);
	public void eliminarPorId(Integer id);
}
