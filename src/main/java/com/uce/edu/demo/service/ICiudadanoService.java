package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	public void insertar(Ciudadano c);
	public Ciudadano buscarPorId(Integer id);
	public void actualizar(Ciudadano c);
	public void eliminarPorId(Integer id);
}
