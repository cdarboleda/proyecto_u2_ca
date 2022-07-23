package com.uce.edu.demo;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;



@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//    	Hotel hote = new Hotel();
//    	hote.setNombre("Hilton Colon");
//    	hote.setDireccion("Patria");
    	
//    	logger.info("Inserción de hotel: ");
//    	this.hotelService.insertar(hote);
    	
    	Habitacion habi1 = new Habitacion();
    	habi1.setNumero("123456");
    	habi1.setPiso("10");
    	habi1.setTipo("Familiar");
    	
    	//basta que tenga la referencia del id, y no todos los parametros
    	Hotel hote1 = new Hotel();
    	hote1.setId(1);
    	habi1.setHotel(hote1);
    	
    	logger.info("Inserción de habitacion: ");
    	this.habitacionService.insertar(habi1);
    }

}
