package com.uce.edu.demo.tarea13.repository;

import java.util.List;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	public void insertar(Estudiante e);
	public Estudiante buscarPorId(Integer id);
	public List<Estudiante> buscarPorEdadNamed(Integer edad);
	public List<Estudiante> buscarPorNombreNamed(String nombre);
	public List<Estudiante> buscarTodosTypedNamed();
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera);
	public List<Estudiante> buscarPorEdadMayorIgualTyped(Integer edad);
	public List<Estudiante> buscarPorNombreContengaPalabra(String palabra);
	public List<Estudiante> buscarPorEdadNative(Integer edad);
	public List<Estudiante> buscarPorCarreraNative(String carrera);
	public List<Estudiante> buscarPorEdadMayorIgualNamedNative(Integer edad);
	public List<Estudiante> buscarPorNombreContengaPalabraNamedNative(String palabra);
	public List<Estudiante> buscarPorEdadCriteria(Integer edad);
	public List<Estudiante> buscarPorCarreraCriteria(String carrera);
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
}
