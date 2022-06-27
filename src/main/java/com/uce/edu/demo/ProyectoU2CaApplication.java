package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = LogManager.getLogger(ProyectoU2CaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //logger.debug("Debugging log");
        logger.info("-------Hola Mundo------");
        //logger.warn("Hey, This is a warning!");
        //logger.error("Oops! We have an Error. OK");
        //logger.fatal("Damn! Fatal error. Please fix me.");
    }

}
