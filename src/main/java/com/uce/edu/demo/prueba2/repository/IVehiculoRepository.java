package com.uce.edu.demo.prueba2.repository;

import com.uce.edu.demo.prueba2.repository.modelo.Vehiculo;

public interface IVehiculoRepository{
	public void insertar(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(String placa);
	
}
