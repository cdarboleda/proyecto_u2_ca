package com.uce.edu.demo.tarea13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea13.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{

	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;
	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(e);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(id);;
	}

	@Override
	public List<Estudiante> buscarPorEdadNamed(Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdadNamed(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreNamed(nombre);
	}

	@Override
	public List<Estudiante> buscarTodosTypedNamed() {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarTodosTypedNamed();
	}

	@Override
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCarreraTypedNamed(carrera);
	}

	@Override
	public List<Estudiante> buscarPorEdadMayorIgualTyped(Integer edad) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdadMayorIgualTyped(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreContengaPalabra(String palabra) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreContengaPalabra(palabra);
	}

}
