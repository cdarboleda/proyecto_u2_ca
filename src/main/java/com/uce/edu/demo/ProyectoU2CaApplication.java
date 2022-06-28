package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.service.IEstudianteJdbcService;
import com.uce.edu.demo.tarea13.to.Estudiante;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	//private static final Logger logger = LogManager.getLogger(ProyectoU2CaApplication.class);
	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	//Insertar
    	Estudiante e = new Estudiante();
    	e.setId(3);
    	e.setNombre("José");
    	e.setApellido("Artigas");
    	e.setCarrera("Ingenieria en Sistemas de Información");
    	e.setEdad(24);
    	this.estudianteJdbcService.insertar(e);
    	logger.info("Se insertó el estudiante"+e);
    	
    	//Actualizar
    	Estudiante e1 = new Estudiante();
    	e1.setId(1);
    	e1.setNombre("Cristian");
    	e1.setApellido("Arboleda");
    	e1.setCarrera("Ingenieria en Computación Gráfica");
    	e1.setEdad(22);
    	this.estudianteJdbcService.actualizar(e1);
    	logger.info("Se actualizó el estudiante"+e1);
    	
    	//Eliminar
    	this.estudianteJdbcService.eliminar(2);
    	logger.info("Se eliminó el estudiante de id: "+2);
    	
    	//Buscar
    	Estudiante e2 = this.estudianteJdbcService.buscarPorId(3);
    	logger.info(e2);
    }

}
