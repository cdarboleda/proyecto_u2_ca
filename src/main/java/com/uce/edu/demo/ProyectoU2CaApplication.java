package com.uce.edu.demo;


import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.tarea13.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
//    	Estudiante e1 = new Estudiante();
//    	e1.setNombre("Christian");
//    	e1.setApellido("López");
//    	e1.setEdad(21);
//    	e1.setCarrera("Diseño Gráfico");
//    	//this.estudianteJpaService.insertar(e1);
//
    	//Busqueda con objetos sencillos
//    	List<PersonaSencilla> listaPer = this.personaJpaService.buscarPorApellidoSencillo("Arboleda");
//
//    	for(PersonaSencilla p: listaPer) {
//    		logger.info(p);
//    	}
//    	
//    	//Busqueda con objetos sencillos
//    	List<PersonaContadorGenero> listaPer2 = this.personaJpaService.consultarCantidadPorGenero();
//
//    	for(PersonaContadorGenero p: listaPer2) {
//    		logger.info(p);
//    	}
    	
    	//Busqueda objetos sencillos
    	List<EstudianteSencillo> listaEst1 = this.estudianteJpaService.buscarPorNombreApellidoSencillo("Cristian", "Arboleda");
    	for(EstudianteSencillo e: listaEst1) {
    		logger.info(e);
    	}
    	
    	//Busqueda objetos sencillos con group by
    	List<EstudianteContadorCarrera> listaEst2 = this.estudianteJpaService.buscarCantidadCarrera("Computación");
    	for(EstudianteContadorCarrera e: listaEst2) {
    		logger.info(e);
    	}

    	
    }

}
