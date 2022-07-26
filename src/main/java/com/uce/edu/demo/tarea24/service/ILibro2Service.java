package com.uce.edu.demo.tarea24.service;

import com.uce.edu.demo.tarea24.repository.modelo.Libro2;

public interface ILibro2Service {
	public void insertar(Libro2 libro);
	public Libro2 buscarPorId(Libro2 libro);
	public void actualizar(Libro2 libro);
	public void eliminarPorId(Integer id);
}
