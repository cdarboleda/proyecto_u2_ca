package com.uce.edu.demo.prueba2.service;

import com.uce.edu.demo.prueba2.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public void insertar(Vehiculo vehiculo);
	public Vehiculo buscarPorId(Integer id);
	public void actualizar(Vehiculo vehiculo);
	public void eliminarPorId(Integer id);
}
