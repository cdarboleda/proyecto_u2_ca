package com.uce.edu.demo.tarea23.repository;

import com.uce.edu.demo.tarea23.repository.modelo.Cliente;

public interface IClienteRepository {
	public void insertar(Cliente cliente);
	public Cliente buscarPorId(Integer id);
	public void actualizar(Cliente cliente);
	public void eliminarPorId(Integer id);
}
