package com.uce.edu.demo;


import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.tarea24.service.IAutor2Service;
import com.uce.edu.demo.tarea24.service.ILibro2Service;

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
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	Factura fact=this.facturaService.consultar(1);

        logger.info("Numero: "+fact.getNumero());
        logger.info("fecha: "+fact.getFecha());
        logger.info("cliente: "+fact.getCliente().getNumeroTarjeta());

        List<Detalle> detalles = fact.getDetalles();
        for(Detalle deta:detalles) {
            logger.info("detalle: Cantidad: "+deta.getCantidad()+" Subtotal: "+deta.getSubtotal());
        }
    	
    }

}
