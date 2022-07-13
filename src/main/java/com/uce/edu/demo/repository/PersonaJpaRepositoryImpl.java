package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.entityManager.find(Persona.class, id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :cedula");
		jpqlQuery.setParameter("cedula", cedula);
		return (Persona)jpqlQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :cedula", Persona.class);
		miTypedQuery.setParameter("cedula", cedula);
		return miTypedQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona)myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona where pers_cedula = :datoCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNamedNative", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		CriteriaBuilder  myBuilder= this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery= myBuilder.createQuery(Persona.class);

		//Root FROM
		Root<Persona> personaRoot = myQuery.from(Persona.class);
		
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery.select(personaRoot).where(myBuilder.equal(personaRoot.get("cedula"), cedula)));
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :genero");
		jpqlQuery.setParameter("genero", genero);
		return jpqlQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		jpqlQuery.setParameter("datoApellido", apellido);	
		return jpqlQuery.getResultList();
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido", Persona.class);
		myQuery.setParameter("datoNombre", nombre);	
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
		
	}
	
	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);	
		return jpqlQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("UPDATE Persona p set p.genero= :datoGenero where p.apellido= :datoApellido");
		query.setParameter("datoApellido", apellido);
		query.setParameter("datoGenero", genero);
		return query.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("DELETE FROM Persona p where p.genero= :datoGenero");
		query.setParameter("datoGenero", genero);
		return query.executeUpdate();
	}




}
