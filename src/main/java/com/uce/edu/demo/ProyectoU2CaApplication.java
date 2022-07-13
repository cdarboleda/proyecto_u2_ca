package com.uce.edu.demo;


import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba2.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba2.service.IPropietarioService;
import com.uce.edu.demo.prueba2.service.IVehiculoService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
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
//    	//NAMED
//    	List<Estudiante> listaEst = this.estudianteJpaService.buscarPorNombreNamed("Gabriel");
//    	for(Estudiante e: listaEst) {
//    		logger.info("NAMED: Buscar por el nombre Gabriel " + e);
//    	}
    	
    	//logger.info(this.personaJpaService.buscarPorCedulaNative("1751146786"));
    	logger.info(this.personaJpaService.buscarPorCedulaNamedNative("1751146786"));
    	
    }

}
