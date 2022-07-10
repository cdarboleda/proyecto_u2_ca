package com.uce.edu.demo.prueba2.repository;

import com.uce.edu.demo.prueba2.repository.modelo.Propietario;

public interface IPropietarioRepository {
	public void crear(Propietario propietario);
	public void eliminar(String cedula);
	public Propietario consultar(String cedula);
}
