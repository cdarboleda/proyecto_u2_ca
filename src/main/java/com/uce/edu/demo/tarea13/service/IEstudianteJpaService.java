package com.uce.edu.demo.tarea13.service;

import java.util.List;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	public void insertar(Estudiante e);
	public Estudiante buscarPorId(Integer id);
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
	public List<Estudiante> buscarPorEdadNamed(Integer edad);
	public List<Estudiante> buscarPorNombreNamed(String nombre);
	public List<Estudiante> buscarTodosTypedNamed();
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera);
	public List<Estudiante> buscarPorEdadMayorIgualTyped(Integer edad);
	public List<Estudiante> buscarPorNombreContengaPalabra(String palabra);
}
