package com.uce.edu.demo.tarea24.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea24.repository.modelo.Libro2;

@Repository
@Transactional
public class Libro2RepositoryImpl implements ILibro2Repository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro2 libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro2 buscarPorId(Libro2 libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Libro2 libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
