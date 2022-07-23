package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetoone.Persona;
import com.uce.edu.demo.repository.modelo.onetoone.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.onetoone.PersonaSencilla;

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
		//"SELECT * FROM persona where pers_cedula = :datoCedula"
		
		//Creamos una instancia de la interfaz CriteriaBuilder
		//que es el builder para construir el SQL
		CriteriaBuilder  myBuilder= this.entityManager.getCriteriaBuilder();
		
		//Especificamos el retorno de mi SQL
		CriteriaQuery<Persona> myQuery= myBuilder.createQuery(Persona.class);
		
		//Aqui empezamos a construir el SQL
		//Root a qué entidad hacemos FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class); //FROM persona
		
		//Aqui se añade el resto de operaciones (SELECT, WHERE =)
		
		//Toda la información del objeto Persona p, se encuentra en el oobjeto Root (personaFrom)
		//Las condiciones where en criteria API se los conoce como predicados, se crean con el BUILDER
		Predicate esIgualCedula = myBuilder.equal(personaFrom.get("cedula"), cedula);
		
		//Se concatenan
		CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaFrom).where(esIgualCedula);
		
		//Creamos un Query normal con el query completo
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQueryCompleto);
		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public List<Persona> buscarDinamicamente(String nombre, String apellido, String genero) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		Root<Persona> personaFrom = myQuery.from(Persona.class);
		//pers_nombre ='Cristian'
		Predicate nombreIgual = myBuilder.equal(personaFrom.get("nombre"), nombre);
		//pers_apellido='Arboleda'
		Predicate apellidoIgual = myBuilder.equal(personaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal;
		if(genero.equals("M")) {
			//Se puede agregar mas condiciones
			
			//pers_nombre ='Cristian' and //pers_apellido='Arboleda'
			predicadoFinal = myBuilder.and(nombreIgual, apellidoIgual);
			
		}else {
			//pers_nombre ='Cristian' or //pers_apellido='Arboleda'
			predicadoFinal= myBuilder.or(nombreIgual, apellidoIgual);
		}
		myQuery.select(personaFrom).where(predicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		
		return myQueryFinal.getResultList();
	}
	
	@Override
	public List<Persona> buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		Root<Persona> personaFrom = myQuery.from(Persona.class);
		Predicate nombreIgual = myBuilder.equal(personaFrom.get("nombre"), nombre);
		Predicate apellidoIgual = myBuilder.equal(personaFrom.get("apellido"), apellido);
		Predicate predicadoGenero = myBuilder.equal(personaFrom.get("genero"), genero);
		
		Predicate predicadoFinal;
		if(genero.equals("M")) {
			predicadoFinal = myBuilder.and(nombreIgual, apellidoIgual);
			predicadoFinal = myBuilder.or(predicadoFinal, predicadoGenero);
			
		}else {
			predicadoFinal= myBuilder.or(nombreIgual, apellidoIgual);
			predicadoFinal = myBuilder.and(predicadoFinal, predicadoGenero);
		}
		myQuery.select(personaFrom).where(predicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		
		return myQueryFinal.getResultList();
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
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		TypedQuery<PersonaSencilla> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre, p.apellido) FROM Persona p WHERE p.apellido = :datoApellido",PersonaSencilla.class);
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		/*
		 * SELECT pers_genero, count(*) FROM public.persona group by pers_genero
		 * */
		String SQL = "SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, count(p.genero)) FROM Persona p GROUP BY p.genero";
		TypedQuery<PersonaContadorGenero> myQuery = this.entityManager.createQuery(SQL,PersonaContadorGenero.class);
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
