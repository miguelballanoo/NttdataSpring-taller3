package com.nttdata.mbg_hibernate_taller1.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.mbg_hibernate_taller1.persistence.NttDataCliente;
import com.nttdata.mbg_hibernate_taller1.persistence.NttDataClienteDaoI;
import com.nttdata.mbg_hibernate_taller1.persistence.NttDataClienteDaoImpl;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Implementacion del servicio de gestion de clientes
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public class NttDataClienteGestionServicioImpl implements NttDataClienteGestionServicioI {

	private NttDataClienteDaoI clienteDao;

	/* Metodo constructor */
	public NttDataClienteGestionServicioImpl(final Session session) {
		this.clienteDao = new NttDataClienteDaoImpl(session);
	}

	@Override
	public void addCliente(NttDataCliente newCliente) {
		// Verificacion de nulidad e inexistencia
		if (newCliente != null && newCliente.getClienteId() == null) {
			clienteDao.insert(newCliente);
		}

	}

	@Override
	public List<NttDataCliente> searchAll() {

		// Resultado.
		List<NttDataCliente> listaClientes = new ArrayList<NttDataCliente>();

		// Obtención de clientes.
		listaClientes = clienteDao.searchAll();

		return listaClientes;
	}

	@Override
	public NttDataCliente searchById(final Long clienteId) {

		// Resultado.
		NttDataCliente cliente = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del contrato por ID.
			cliente = clienteDao.searchById(clienteId);
		}

		return cliente;
	}

	@Override
	public void deleteCliente(NttDataCliente clienteABorrar) {
		if (clienteABorrar != null && clienteABorrar.getClienteId() == null) {
			clienteDao.delete(clienteABorrar);
		}

	}

	@Override
	public void updateCliente(NttDataCliente clienteAActualizar) {
		if (clienteAActualizar != null && clienteAActualizar.getClienteId() == null) {
			clienteDao.update(clienteAActualizar);
		}

	}

	@Override
	public List<NttDataCliente> searchByNameAndSurname(String nombre, String primerApellido, String segundoApellido) {
		List<NttDataCliente> listaClientes = null;

		if (nombre != null && primerApellido != null && segundoApellido != null) {
			listaClientes = clienteDao.searchByNameAndSurname(nombre, primerApellido, segundoApellido);
		}

		return listaClientes;
	}

	@Override
	public List<NttDataCliente> searchByDni(String dni) {
		List<NttDataCliente> listaClientes = null;

		if (dni != null) {
			listaClientes = clienteDao.searchByDni(dni);
		}

		return listaClientes;
	}

}
