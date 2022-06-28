package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.to.Estudiante;

public interface IEstudianteJdbcRepository {
	public void insertar(Estudiante e);
	public Estudiante buscarPorId(int id);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
}
