package com.nttdata.mbg_hibernate_taller1.services;

import java.util.List;

import com.nttdata.mbg_hibernate_taller1.persistence.NttDataContrato;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Implementacion del servicio de gestion de contratos
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public interface NttDataContratoGestionServicioI {
	
	/**
	 * Inserta un nuevo contrato
	 * @param newContrato
	 * */
	public void addContrato(final NttDataContrato newContrato);

	
	/**
	 * Consulta todos los contratos
	 * */
	public List<NttDataContrato>searchAll();
	
	
	/**
	 * Obtiene un contrato mediante su ID.
	 * @param contratoId
	 */
	public NttDataContrato searchById(final Long contratoId);
	
	
	/**
	 * Elimina un contrato existente.
	 * @param contratoAEliminar
	 */
	public void deleteContrato(final NttDataContrato contratoAEliminar);
	
	
	/**
	 * Actualiza un contrato existente.
	 * @param contratoeActualizado
	 */
	public void updateContrato(final NttDataContrato contratoActualizado);
	
	
	/**
	 * Obtiene un cliente a partir de su id
	 * @param clienteId
	 * */
	public List<NttDataContrato> searchClienteById(final Long clienteId);
	
	
	/**
	 * Obtiene un contrato a trves del id de contrato y del nombre del cliente que tiene asociado
	 * @param nameCliente
	 * @param contratoId
	 * */
	public List<NttDataContrato> searchByNameClienteAndIdContrato(String nameCliente, Long contratoId);
}
