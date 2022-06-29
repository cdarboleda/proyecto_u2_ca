package com.uce.edu.demo.tarea13.service;

import com.uce.edu.demo.tarea13.to.EstudianteTo;

public interface IEstudianteJdbcService {
	public void insertar(EstudianteTo e);
	public EstudianteTo buscarPorId(int id);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);
}
