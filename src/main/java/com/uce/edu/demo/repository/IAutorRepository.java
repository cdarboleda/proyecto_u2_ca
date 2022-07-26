package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;

public interface IAutorRepository {
	public void insertar(Autor autor);
	public Autor buscarPorId(Autor autor);
	public void actualizar(Autor autor);
	public void eliminarPorId(Integer id);
}
