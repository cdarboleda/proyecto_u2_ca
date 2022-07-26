package com.uce.edu.demo.tarea24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea24.repository.ILibroAutor2Repository;
import com.uce.edu.demo.tarea24.repository.modelo.LibroAutor2;

@Service
public class LibroAutor2ServiceImpl implements ILibroAutor2Service {

	@Autowired
	private ILibroAutor2Repository libroAutor2Repository;
	
	@Override
	public void insertar(LibroAutor2 libroAutor2) {
		// TODO Auto-generated method stub
		this.libroAutor2Repository.insertar(libroAutor2);
	}

}
