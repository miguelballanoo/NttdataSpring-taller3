package com.nttdata.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.NttDataCliente;
import com.nttdata.spring.persistence.NttDataClienteRepository;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Implementacion del servicio de gestion de clientes
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
@Service
public class NttDataClienteGestionServicioImpl implements NttDataClienteGestionServicioI {

	@Autowired
	private NttDataClienteRepository clienteRepository;

	@Override
	public List<NttDataCliente> searchAll() {

		// Resultado.
		List<NttDataCliente> listaClientes = new ArrayList<NttDataCliente>();

		// Obtención de clientes.
		listaClientes = clienteRepository.findAll();

		return listaClientes;
	}

	@Override
	public NttDataCliente searchById(final Long clienteId) {

		// Resultado.
		Optional<NttDataCliente> cliente = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del contrato por ID.
			cliente = clienteRepository.findById(clienteId);
		}

		return cliente.get();
	}

	@Override
	public void deleteCliente(NttDataCliente clienteABorrar) {
		if (clienteABorrar != null && clienteABorrar.getClienteId() == null) {
			clienteRepository.delete(clienteABorrar);
		}

	}

	@Override
	public void updateCliente(NttDataCliente clienteAActualizar) {
		if (clienteAActualizar != null && clienteAActualizar.getClienteId() == null) {
			clienteRepository.save(clienteAActualizar);
		}

	}

	@Override
	public void addCliente(NttDataCliente newCliente) {
		if (newCliente != null) {
			clienteRepository.save(newCliente);
		}

	}

	@Override
	public List<NttDataCliente> findByNameAndFirstSurname(String name, String firstSurname) {

		List<NttDataCliente> clientes = new ArrayList();

		if (name != null && firstSurname != null) {
			clientes = clienteRepository.findByNameAndFirstSurname(name, firstSurname);
		}

		return clientes;
	}

	@Override
	public List<NttDataCliente> searchByDni(String dni) {
		List<NttDataCliente> clientes = new ArrayList();

		if (dni!= null) {
			clientes = clienteRepository.findByDni(dni);
		}

		return clientes;
	}

}
