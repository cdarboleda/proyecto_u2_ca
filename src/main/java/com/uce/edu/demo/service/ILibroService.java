package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

public interface ILibroService {
	public void insertar(Libro libro);
	public Libro buscarPorId(Libro libro);
	public void actualizar(Libro libro);
	public void eliminarPorId(Integer id);
}
