package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;

public interface IAutorService {
	public void insertar(Autor autor);
	public Autor buscarPorId(Autor autor);
	public void actualizar(Autor autor);
	public void eliminarPorId(Integer id);
}
