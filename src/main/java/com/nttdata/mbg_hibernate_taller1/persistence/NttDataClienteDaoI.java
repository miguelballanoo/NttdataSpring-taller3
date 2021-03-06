package com.nttdata.mbg_hibernate_taller1.persistence;

import java.util.List;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Clase HibernateUtil
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
