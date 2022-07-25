package com.uce.edu.demo.tarea23.service;

import com.uce.edu.demo.tarea23.repository.modelo.Factura;

public interface IFacturaService {
	public void insertar(Factura factura);
	public Factura buscarPorId(Integer id);
	public void actualizar(Factura factura);
	public void eliminarPorId(Integer id);
}
