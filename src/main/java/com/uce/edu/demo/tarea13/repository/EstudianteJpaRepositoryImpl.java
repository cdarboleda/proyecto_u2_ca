package com.uce.edu.demo.tarea13.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.entityManager.persist(e);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante e = this.entityManager.find(Estudiante.class, id);
		this.entityManager.remove(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> buscarPorEdadNamed(Integer edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad");
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> buscarPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (List<Estudiante>)myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarTodosTypedNamed() {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarTodos", Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCarreraTypedNamed(String carrera){
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCarrera", Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadMayorIgualTyped(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e where e.edad >= :datoEdad", Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreContengaPalabra(String palabra) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e where e.nombre LIKE CONCAT(:datoPalabra,'%')", Estudiante.class);
		myQuery.setParameter("datoPalabra", palabra);
		return myQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> buscarPorEdadNative(Integer edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_edad = :datoEdad", Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return (List<Estudiante>)myQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> buscarPorCarreraNative(String carrera) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_carrera = :datoCarrera", Estudiante.class);
		myQuery.setParameter("datoCarrera", carrera);
		return (List<Estudiante>)myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadMayorIgualNamedNative(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadMayorIgual", Estudiante.class);
		myQuery.setParameter("datoEdad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreContengaPalabraNamedNative(String palabra) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreContengaPalabra", Estudiante.class);
		myQuery.setParameter("datoPalabra", palabra);
		return myQuery.getResultList();
	}

}
