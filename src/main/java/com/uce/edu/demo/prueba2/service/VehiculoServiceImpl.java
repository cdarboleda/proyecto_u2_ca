package com.uce.edu.demo.prueba2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba2.repository.IVehiculoRepository;
import com.uce.edu.demo.prueba2.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public Vehiculo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.eliminarPorId(id);
	}

}
