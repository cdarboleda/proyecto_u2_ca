package com.uce.edu.demo.tarea24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea24.repository.IAutor2Repository;
import com.uce.edu.demo.tarea24.repository.modelo.Autor2;

@Service
public class Autor2ServiceImpl implements IAutor2Service {

	@Autowired
	private IAutor2Repository autor2Repository;
	
	@Override
	public void insertar(Autor2 autor) {
		// TODO Auto-generated method stub
		this.autor2Repository.insertar(autor);
	}

	@Override
	public Autor2 buscarPorId(Autor2 autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Autor2 autor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub

	}

}
