package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea13.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	//private static final Logger logger = LogManager.getLogger(ProyectoU2CaApplication.class);
	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//    	//Insertar
//    	Estudiante e = new Estudiante();
//    	e.setId(2);
//    	e.setNombre("José");
//    	e.setApellido("Artigas");
//    	e.setCarrera("Ingeniería en Computación");
//    	e.setEdad(22);
//    	this.estudianteJpaService.insertar(e);
//    	logger.info("Inserción con JPA: "+ e);
//
//    	//Actualizar
//    	Estudiante e1 = new Estudiante();
//    	e1.setId(3);
//    	e1.setNombre("Andrea");
//    	e1.setApellido("Mejía");
//    	e1.setCarrera("Ingeniería en Computación");
//    	e1.setEdad(19);
//    	this.estudianteJpaService.actualizar(e1);
//    	logger.info("Actualizacion con JPA: "+ e1);
//    	
//    	//Eliminar
//    	Integer id = 2;
//    	this.estudianteJpaService.eliminar(id);
//    	logger.info("Eliminación con JPA: "+ id);
//    	
//    	//Buscar
//    	logger.info("Dato con JPA: "+this.estudianteJpaService.buscarPorId(1));
    	
    	
    	Persona p = new Persona();
    	//p.setId(4);
    	p.setNombre("David");
    	p.setApellido("Jumbo");
    	this.personaJpaService.guardar(p);
    	logger.info("Inserción con JPA: "+ p);
    	
    	Persona p1 = new Persona();
    	//p1.setId(1);
    	p1.setNombre("Andrea");
    	p1.setApellido("Solis");
    	//his.personaJpaService.actualizar(p1);
    	//logger.info("Actualizacion con JPA: "+ p);
    	
    	//this.personaJpaService.eliminar(4);
    	//logger.info("Eliminación con JPA: "+ p);
    	
    }

}
