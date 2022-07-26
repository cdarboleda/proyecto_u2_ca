package com.uce.edu.demo.tarea24.repository;

import com.uce.edu.demo.tarea24.repository.modelo.Autor2;

public interface IAutor2Repository {
	public void insertar(Autor2 autor);
	public Autor2 buscarPorId(Autor2 autor);
	public void actualizar(Autor2 autor);
	public void eliminarPorId(Integer id);
}
