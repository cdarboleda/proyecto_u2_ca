package com.uce.edu.demo;


import java.util.HashSet;
import java.util.Set;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;



@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

	@Autowired
	private ILibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
    	Libro lib1 = new Libro();
    	lib1.setTitulo("Titulo 1");
    	lib1.setCantidad_paginas(200);
    	
    	Autor autor1 = new Autor();
    	autor1.setNombre("Cristian");
    	
    	Set<Autor> autores = new HashSet<>();
    	autores.add(autor1);
    	
    	lib1.setAutores(autores);
    	
    	this.libroService.insertar(lib1);
    	
    }

}
