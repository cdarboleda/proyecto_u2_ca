package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
	
	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public void insertar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(c);
	}

	@Override
	public Ciudadano buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(c);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminarPorId(id);
	}

}
