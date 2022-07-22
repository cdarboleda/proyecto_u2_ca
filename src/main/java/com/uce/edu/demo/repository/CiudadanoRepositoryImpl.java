package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.persist(c);
	}

	@Override
	public Ciudadano buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.merge(c);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano c = buscarPorId(id);
		this.entityManager.remove(c);
	}

}
