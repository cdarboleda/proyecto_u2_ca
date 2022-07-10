package com.uce.edu.demo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba2.repository.modelo.Propietario;
import com.uce.edu.demo.prueba2.repository.modelo.Vehiculo;
import com.uce.edu.demo.prueba2.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba2.service.IPropietarioService;
import com.uce.edu.demo.prueba2.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2CaApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger(ProyectoU2CaApplication.class);

	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IMatriculaGestorService matriculaGestorService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2CaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

		//1
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Totota");
		vehiculo.setPlaca("PCT8976");
		vehiculo.setPrecio(new BigDecimal(50000));
		vehiculo.setTipo("L");
		
		//this.vehiculoService.insertar(vehiculo);
		//logger.info(vehiculo);
		
		//2
		vehiculo.setPrecio(new BigDecimal(25000));
		vehiculo.setMarca("Honda");
		this.vehiculoService.actualizar(vehiculo);
		logger.info("Actualizado: " + vehiculo);
		
		//3
		Propietario propietario = new Propietario();
		propietario.setNombre("David");
		propietario.setApellido("Jumbo");
		propietario.setCedula("1253687452");
		propietario.setFechaNacimiento(LocalDateTime.of(2000, 2,4,0,0));
		this.propietarioService.crear(propietario);
		logger.info("Crear: " +propietario);
		
		//4
		//this.matriculaGestorService.generar("1751146786", "PCT8976");
    }

}
