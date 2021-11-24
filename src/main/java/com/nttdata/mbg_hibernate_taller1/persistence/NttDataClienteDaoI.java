package com.nttdata.mbg_hibernate_taller1.persistence;

import java.util.List;



/**
 * Ejercicio Hibernate [Taller 1]
 * 
 * DAO de tabla CLIENTE
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public interface NttDataClienteDaoI extends CommonDaoI<NttDataCliente> {

	
	/**
	 * Obtiene clientes por nombre y apellidos
	 * 
	 * @param nombreCliente
	 * @return List<NttDataCliente>
	 */
	public List<NttDataCliente> searchByNameAndSurname(final String nombreCliente, final String primerApellido, final String segundoApellido);
	
	/**
	 * Obtiene clientes por dni
	 * 
	 * @param dni
	 * @return List<NttDataCliente>
	 */
	public List<NttDataCliente> searchByDni(final String dni);
}
