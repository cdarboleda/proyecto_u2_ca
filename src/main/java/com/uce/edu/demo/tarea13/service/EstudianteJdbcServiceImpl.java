package com.uce.edu.demo.tarea13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea13.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.tarea13.to.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{

	@Autowired
	private IEstudianteJdbcRepository estudianteRepository;
	
	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(e);
	}

	@Override
	public Estudiante buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

}
