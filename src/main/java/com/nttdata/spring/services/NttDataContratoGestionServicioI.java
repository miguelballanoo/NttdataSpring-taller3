package com.nttdata.spring.services;

import java.util.List;


import com.nttdata.spring.persistence.NttDataContrato;

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
	 * Busca contratos que esten asociados a un cliente sabiendo el id del cliente
	 * @param clienteId
	 * @return List<NttDataContrato>
	 * */
	public List<NttDataContrato> searchClienteById( long clienteId);
}
