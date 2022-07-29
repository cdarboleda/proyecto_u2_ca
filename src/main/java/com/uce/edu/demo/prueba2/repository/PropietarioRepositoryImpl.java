package com.uce.edu.demo.prueba2.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba2.repository.modelo.Propietario;


@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		Propietario p = this.entityManager.find(Propietario.class, id);
		this.entityManager.remove(p);
	}

	@Override
	public Propietario consultarPorId(Integer id) {
		// TODO Auto-generated method stub	
		return this.entityManager.find(Propietario.class, id);
	}

}
