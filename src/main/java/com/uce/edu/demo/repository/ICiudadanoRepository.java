package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

public interface ICiudadanoRepository {
	public void insertar(Ciudadano c);
	public Ciudadano buscarPorId(Integer id);
	public void actualizar(Ciudadano c);
	public void eliminarPorId(Integer id);
}
