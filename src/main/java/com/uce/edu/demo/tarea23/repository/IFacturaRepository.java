package com.uce.edu.demo.tarea23.repository;

import com.uce.edu.demo.tarea23.repository.modelo.Factura;

public interface IFacturaRepository {
	public void insertar(Factura factura);
	public Factura buscarPorId(Integer id);
	public void actualizar(Factura factura);
	public void eliminarPorId(Integer id);
}
