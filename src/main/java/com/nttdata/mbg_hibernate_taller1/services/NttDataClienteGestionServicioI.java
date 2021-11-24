package com.nttdata.mbg_hibernate_taller1.services;

import java.util.List;

import com.nttdata.mbg_hibernate_taller1.persistence.NttDataCliente;

public interface NttDataClienteGestionServicioI {
	/**
	 * Inserta un nuevo cliente.
	 * @param newCliente
	 */
	public void addCliente(final NttDataCliente newCliente);


	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<NttDataCliente>
	 */
	public List<NttDataCliente> searchAll();


	/**
	 * Obtiene un cliente mediante su ID.
	 * @param clienteId
	 */
	public NttDataCliente searchById(final Long clienteId);
	
	
	/**
	 * Elimina un cliente existente.
	 * @param clienteAEliminar
	 */
	public void deleteCliente(final NttDataCliente clienteAEliminar);
	
	
	/**
	 * Actualiza un cliente existente.
	 * @param clienteActualizado
	 */
	public void updateCliente(final NttDataCliente clienteActualizado);
	

	/**
	 * Obtiene un cliente por el nombre y los apellidos
	 * 
	 * @param nombr
	 * @param primerApellido
	 * @param segundoApellido
	 * */
	public List<NttDataCliente> searchByNameAndSurname(final String nombre, final String primerApellido, final String segundoApellido);


	/**
	 * Obtiene clientes por dni
	 * 
	 * @param dni
	 * @return List<NttDataCliente>
	 */
	public List<NttDataCliente> searchByDni(final String dni);

}
