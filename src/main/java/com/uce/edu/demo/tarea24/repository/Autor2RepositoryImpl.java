package com.uce.edu.demo.tarea24.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea24.repository.modelo.Autor2;

@Repository
@Transactional
public class Autor2RepositoryImpl implements IAutor2Repository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor2 autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor2 buscarPorId(Autor2 autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Autor2 autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
