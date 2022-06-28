package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	//private static final Logger logger = LogManager.getLogger(ProyectoU2CaApplication.class);
	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private IPersonaJdbcService personaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	//Insertar
    	Persona persona = new Persona();
    	persona.setId(2);
    	persona.setNombre("David");
    	persona.setApellido("Jumbo");
    	//this.personaJdbcService.guardar(persona);
    	
    	//Actualizar
    	Persona persona1 = new Persona();
    	persona1.setId(1);
    	persona1.setNombre("Pepito");
    	persona1.setApellido("Velez");
    	//this.personaJdbcService.actualizar(persona1);
    	
    	//Eliminar
    	//this.personaJdbcService.eliminar(4);
    	
    	//Buscar
    	Persona p3 = this.personaJdbcService.buscarPorId(2);
    	logger.info(p3);
    }

}
