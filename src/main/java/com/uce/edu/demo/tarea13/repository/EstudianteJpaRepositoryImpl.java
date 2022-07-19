package com.uce.edu.demo.tarea13.repository;

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

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo;

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

	@Override
	public List<Estudiante> buscarPorEdadCriteria(Integer edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante> estudianteFrom =  myQuery.from(Estudiante.class);
		Predicate predicadoEdad;
		
		//si la edad es número par devuelve los estudiantes que sean mayor o igual a esa edad
		if (edad %2 ==0) {
			predicadoEdad = myBuilder.greaterThanOrEqualTo(estudianteFrom.get("edad"), edad);
		}else {
			//caso contrario devuelve a los que sean menor o igual a esa edad
			predicadoEdad = myBuilder.lessThanOrEqualTo(estudianteFrom.get("edad"), edad);
		}
		
		myQuery.select(estudianteFrom).where(predicadoEdad);
		
		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(myQuery);
		
		return queryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorCarreraCriteria(String carrera) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante> estudianteFrom = myQuery.from(Estudiante.class);
		Predicate predicadoCarrera;
		
		//Si la carrera es Computación buscar a los estudiantes con inicial C
		if (carrera.equals("Computación")) {
			predicadoCarrera = myBuilder.equal(estudianteFrom.get("carrera"), "Computación");
			Predicate predicadoNombre = myBuilder.like(estudianteFrom.get("nombre"), "C%");
			Predicate predicadoAux = myBuilder.and(predicadoCarrera, predicadoNombre);
			myQuery.select(estudianteFrom).where(predicadoAux);
		}else {
			//Caso contrario buscar a todos los que no son Computación
			predicadoCarrera = myBuilder.notEqual(estudianteFrom.get("carrera"), "Computación");
			myQuery.select(estudianteFrom).where(predicadoCarrera);
		}
	
		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(myQuery);
		
		return queryFinal.getResultList();

	}

	@Override
	public List<EstudianteSencillo> buscarPorNombreApellidoSencillo(String nombre, String apellido) {
		String sql = "SELECT NEW com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo(e.nombre, e.apellido, e.carrera) FROM Estudiante e WHERE e.nombre = :datoNombre AND e.apellido = :datoApellido ORDER BY e.id ASC";
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(sql,EstudianteSencillo.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorCarrera> buscarCantidadCarrera(String carrera) {
		String sql = "SELECT NEW com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera(e.carrera, count(e.carrera)) FROM Estudiante e WHERE e.carrera = :datoCarrera GROUP BY e.carrera ORDER BY e.carrera DESC";
		TypedQuery<EstudianteContadorCarrera> myQuery = this.entityManager.createQuery(sql, EstudianteContadorCarrera.class);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

}
