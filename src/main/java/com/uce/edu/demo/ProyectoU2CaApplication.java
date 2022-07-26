package com.uce.edu.demo;


import java.util.ArrayList;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea24.repository.modelo.Autor2;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2;
import com.uce.edu.demo.tarea24.repository.modelo.LibroAutor2;
import com.uce.edu.demo.tarea24.service.IAutor2Service;
import com.uce.edu.demo.tarea24.service.ILibro2Service;
import com.uce.edu.demo.tarea24.service.ILibroAutor2Service;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

//	@Autowired
//	private ILibroService libroService;
	@Autowired
	private ILibro2Service libro2Service;
	
	@Autowired
	private IAutor2Service autor2Service;
	
	@Autowired
	private ILibroAutor2Service libroAutor2Service;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
//    	Libro lib1 = new Libro();
//    	lib1.setTitulo("Titulo 1");
//    	lib1.setCantidad_paginas(200);
//    	
//    	Autor autor1 = new Autor();
//    	autor1.setNombre("Cristian");
//    	
//    	Set<Autor> autores = new HashSet<>();
//    	autores.add(autor1);
//    	
//    	lib1.setAutores(autores);
//    	
//    	this.libroService.insertar(lib1);
    	
    	Libro2 lib2 = new Libro2();
    	lib2.setCantidad_paginas(200);
    	lib2.setTitulo("ADios");
    	this.libro2Service.insertar(lib2);
    	
    	Libro2 lib3 = new Libro2();
    	lib3.setCantidad_paginas(100);
    	lib3.setTitulo("Chao");
    	this.libro2Service.insertar(lib3);
    	
    	Autor2 autor2 = new Autor2();
    	autor2.setNombre("David");
    	this.autor2Service.insertar(autor2);
    	
    	LibroAutor2 libroAutor2 = new LibroAutor2();
    	lib2.setId(2);
    	autor2.setId(1);
    	libroAutor2.setAutor2(autor2);
    	libroAutor2.setLibro2(lib2);
    	
    	LibroAutor2 libroAutor3 = new LibroAutor2();
    	lib3.setId(3);
    	autor2.setId(2);
    	libroAutor3.setAutor2(autor2);
    	libroAutor3.setLibro2(lib3);
    	
    	List<LibroAutor2> listaRompimiento = new ArrayList<>();
    	listaRompimiento.add(libroAutor2);
    	listaRompimiento.add(libroAutor3);
    	
    	this.libroAutor2Service.insertar(libroAutor2);
    	this.libroAutor2Service.insertar(libroAutor3);
    	
    }

}
