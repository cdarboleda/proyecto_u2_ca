package com.uce.edu.demo;


import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

	@Autowired
	private IPersonaJpaService personaJpaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
    	//Actualizar con JPQL
    	int resultado = this.personaJpaService.actualizarPorApellido("Masculino", "Vélez");
    	logger.info("Cantidad de registros actualizados: " + resultado);
    	
    	//Eliminarcon JPQL
    	int resultado2 = this.personaJpaService.eliminarPorGenero("Masculino");
    	logger.info("Cantidad de registros eliminados: " + resultado2);
    }

}
