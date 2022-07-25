package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.tarea23.repository.modelo.Cliente;
import com.uce.edu.demo.tarea23.service.IClienteService;
import com.uce.edu.demo.tarea23.service.IFacturaService;



@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
    	//Insertar un cliente sin factura
    	logger.info("\nCreando un cliente sin factura: ");
    	Cliente clie1 = new Cliente();
    	clie1.setCedula("175143786");
    	clie1.setNombre("Cristian");
    	this.clienteService.insertar(clie1);
    	
    	//Actualizar un cliente
    	logger.info("\nActualizando un cliente: ");
    	clie1.setNombre("Antonio");
    	this.clienteService.actualizar(clie1);
    	
    	//Buscar un cliente
    	logger.info("\nBuscando un cliente: ");
    	Cliente c = this.clienteService.buscarPorId(4);
    	logger.info(c);
    	
    	//Eliminar un cliente
    	logger.info("\nEliminando un cliente: ");
    	this.clienteService.eliminarPorId(4);
    	
    	
    }

}
