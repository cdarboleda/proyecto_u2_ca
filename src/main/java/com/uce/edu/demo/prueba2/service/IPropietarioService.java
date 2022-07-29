package com.uce.edu.demo.prueba2.service;

import com.uce.edu.demo.prueba2.repository.modelo.Propietario;

public interface IPropietarioService {
	public void crear(Propietario propietario);
	public void eliminarPorId(Integer id);
}
