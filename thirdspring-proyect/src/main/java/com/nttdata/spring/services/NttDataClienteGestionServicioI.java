package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.persistence.NttDataCliente;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Servicio de gestion de cliente
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */

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
	 * Actualiza un cliente existente.
	 * @param clienteActualizado
	 */
	public List <NttDataCliente> findByNameAndFirstSurname(String name, String firstSurname);
	
	/**
	 * Busca un cliente por su dni
	 * @param dni
	 * @return List<NttDataCliente>
	 * 
	 */
	public List <NttDataCliente> searchByDni(String dni);
}
