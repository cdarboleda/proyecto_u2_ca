package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.to.EstudianteTo;

public interface IEstudianteJdbcRepository {
	public void insertar(EstudianteTo e);
	public EstudianteTo buscarPorId(int id);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);
}
