package com.uce.edu.demo.tarea23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea23.repository.IFacturaRepository;
import com.uce.edu.demo.tarea23.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.insertar(factura);
	}

	@Override
	public Factura buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminarPorId(id);
	}

}
