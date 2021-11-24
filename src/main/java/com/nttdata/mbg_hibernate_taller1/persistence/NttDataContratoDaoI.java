package com.nttdata.mbg_hibernate_taller1.persistence;

import java.util.List;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Interdaz NttDataContratoDao
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public interface NttDataContratoDaoI extends CommonDaoI<NttDataContrato>{

	/**
	 * Busca el contrato que tiene asociado el cliente que le pasamos como parametros
	 * 
	 * @param clienteId
	 * @return List<NttDataContrato>
	 * */
	public List<NttDataContrato> searchByIdCliente(final Long clienteId);
	
	/**
	 * Busca el contrato con el nombre del cliente y del identificador del contrato que se le pasa como paramerto
	 * 
	 * @param nameCliente
	 * @param contratoId
	 * @return List<NttDataContrato>
	 * */
	public List<NttDataContrato> searchByNameClienteAndIdContrato(String nameCliente, Long contratoId);
}
