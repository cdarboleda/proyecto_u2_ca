package com.uce.edu.demo.tarea13.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.to.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public Estudiante buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where id =?",
				new Object[] {id},
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id, nombre, apellido, carrera, edad) values (?,?,?,?,?)",
				new Object[] {e.getId(), e.getNombre(), e.getApellido(), e.getCarrera(), e.getEdad()});
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?, apellido=?, carrera=?, edad=? where id = ?", 
				new Object[] {e.getNombre(), e.getApellido(), e.getCarrera(), e.getEdad(), e.getId()});
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where id = ?", new Object[] {id});
	}
}
