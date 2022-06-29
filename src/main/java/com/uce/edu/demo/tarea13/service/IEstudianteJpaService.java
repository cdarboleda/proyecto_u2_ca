package com.uce.edu.demo.tarea13.service;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	public void insertar(Estudiante e);
	public Estudiante buscarPorId(Integer id);
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
}
