package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	//private static final Logger logger = LogManager.getLogger(ProyectoU2CaApplication.class);
	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

	@Autowired
	private IPersonaJpaService personaJpaService;
	
	@Autowired
	private IPersonaJdbcService personaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	//Insertar
    	Persona p = new Persona();
    	p.setId(4);
    	p.setNombre("José");
    	p.setApellido("Artigas");
    	//this.personaJpaService.guardar(p);
    	//logger.info("Inserción con JPA: "+ p);

    	//Actualizar
    	Persona p1 = new Persona();
    	p1.setId(1);
    	p1.setNombre("Andrea");
    	p1.setApellido("Solis");
    	//his.personaJpaService.actualizar(p1);
    	//logger.info("Actualizacion con JPA: "+ p);
    	
    	//Eliminar
    	this.personaJpaService.eliminar(4);
    	//logger.info("Eliminación con JPA: "+ p);
    	
    	//Buscar
    	//logger.info("Dato con JPA: "+this.personaJpaService.buscarPorId(2));
    	
    	
    }

}
