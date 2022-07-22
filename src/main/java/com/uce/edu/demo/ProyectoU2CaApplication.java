package com.uce.edu.demo;


import java.time.LocalDateTime;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;



@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    	
    	Ciudadano c1 = new Ciudadano();
    	c1.setNombre("David");
    	c1.setApellido("Jumbo");
    	c1.setCedula("1725635214");
    	c1.setFechaNacimiento(LocalDateTime.of(1999, 01,02,0,0));
    	
    	//Un ciudadano no siempre va a tener pasaporte
    	//this.ciudadanoService.insertar(c1);
//    	
    	Pasaporte p1 = new Pasaporte();
    	p1.setFechaCaducidad(LocalDateTime.of(2023, 11,22,0,0));
    	p1.setFechaEmision(LocalDateTime.of(2022, 11,22,0,0));
    	p1.setNumero("123457");
//    	
//    	
    	//Si es que seteamos un Empleado si antes establecer el Cascade en su atributo en Ciudadnano nos da error
    	c1.setPasaporte(p1);
    	p1.setCiudadano(c1);
//    	//Con el cascade, al insertar el ciudadano, se insertó el empleado
    	logger.info("\n");
    	logger.info("Insertar"+ c1);
    	this.ciudadanoService.insertar(c1);
    	logger.info("\n");
    	
    	c1.setNombre("Andres");
    	logger.info("Actualizar"+ c1);
    	this.ciudadanoService.actualizar(c1);
    	logger.info("\n");
    	
    	logger.info("Buscar por id 3"+this.ciudadanoService.buscarPorId(3)+"\n");
    	
    	logger.info("Eliminar por id 3");
    	this.ciudadanoService.eliminarPorId(3);;
    	
    }

}
