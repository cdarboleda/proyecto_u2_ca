package com.uce.edu.demo.tarea23.service;

import com.uce.edu.demo.tarea23.repository.modelo.Cliente;

public interface IClienteService {
	public void insertar(Cliente cliente);
	public Cliente buscarPorId(Integer id);
	public void actualizar(Cliente cliente);
	public void eliminarPorId(Integer id);
}
