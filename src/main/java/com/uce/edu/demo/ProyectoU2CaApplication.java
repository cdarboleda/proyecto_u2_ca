package com.uce.edu.demo;


import java.math.BigDecimal;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IPersonaJpaService;
import com.uce.edu.demo.tarea13.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
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
    	
    	Ciudadano c1 = new Ciudadano();
    	c1.setNombre("David");
    	c1.setApellido("Jumbo");
    	
    	//Un ciudadano no siempre va a ser un Empleado
    	//this.ciudadanoService.insertar(c1);
    	
    	Empleado empl1 = new Empleado();
    	empl1.setCiudadano(c1);
    	empl1.setCodigoIess("12123");
    	empl1.setSalario(new BigDecimal(100));
    	
    	//Si es que seteamos un Empleado si antes establecer el Cascade en su atributo en Ciudadnano nos da error
    	c1.setEmpleado(empl1);
    	//Con el cascade, al insertar el ciudadano, se insertó el empleado
    	this.ciudadanoService.insertar(c1);
    	
    }

}
