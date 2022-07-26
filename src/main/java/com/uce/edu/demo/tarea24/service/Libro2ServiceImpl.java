package com.uce.edu.demo.tarea24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea24.repository.ILibro2Repository;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2;

@Service
public class Libro2ServiceImpl implements ILibro2Service {

	@Autowired
	private ILibro2Repository libro2Repository;
	
	@Override
	public void insertar(Libro2 libro) {
		// TODO Auto-generated method stub
		this.libro2Repository.insertar(libro);
	}

	@Override
	public Libro2 buscarPorId(Libro2 libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Libro2 libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub

	}

}
