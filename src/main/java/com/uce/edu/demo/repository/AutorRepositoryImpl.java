package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public Autor buscarPorId(Autor autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub

	}

}
