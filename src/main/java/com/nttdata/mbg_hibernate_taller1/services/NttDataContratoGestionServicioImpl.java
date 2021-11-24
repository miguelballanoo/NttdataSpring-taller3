package com.nttdata.mbg_hibernate_taller1.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.mbg_hibernate_taller1.persistence.NttDataContrato;
import com.nttdata.mbg_hibernate_taller1.persistence.NttDataContratoDaoI;
import com.nttdata.mbg_hibernate_taller1.persistence.NttDataContratoDaoImpl;

public class NttDataContratoGestionServicioImpl implements NttDataContratoGestionServicioI {

	private NttDataContratoDaoI contratoDao;

	/* Constructor */
	public NttDataContratoGestionServicioImpl(final Session session) {
		super();
		this.contratoDao = new NttDataContratoDaoImpl(session);
	}

	@Override
	public void addContrato(NttDataContrato newContrato) {
		if (newContrato != null && newContrato.getContratoId() == null) {
			contratoDao.insert(newContrato);
		}

	}

	@Override
	public List<NttDataContrato> searchAll() {
		List<NttDataContrato> listaContratos = new ArrayList<NttDataContrato>();

		// Obtención de contratos.
		listaContratos = contratoDao.searchAll();

		return listaContratos;
	}

	@Override
	public NttDataContrato searchById(Long contratoId) {
		// Resultado.
		NttDataContrato contrato = null;

		// Verificación de nulidad.
		if (contratoId != null) {

			// Obtención del contrato por ID.
			contrato = contratoDao.searchById(contratoId);
		}

		return contrato;
	}

	@Override
	public void deleteContrato(NttDataContrato contratoAEliminar) {
		if (contratoAEliminar != null && contratoAEliminar.getContratoId() == null) {
			contratoDao.delete(contratoAEliminar);
		}

	}

	@Override
	public void updateContrato(NttDataContrato contratoActualizado) {
		if (contratoActualizado != null && contratoActualizado.getContratoId() == null) {
			contratoDao.update(contratoActualizado);
		}

	}

	@Override
	public List<NttDataContrato> searchClienteById(Long clienteId) {
		// Resultado
		List<NttDataContrato> listContracts = null;

		if (clienteId != null) {
			// Obtengo el cliente a partir de su identificador
			listContracts = contratoDao.searchByIdCliente(clienteId);
		}
		return listContracts;
	}

	@Override
	public List<NttDataContrato> searchByNameClienteAndIdContrato(String nameCliente, Long contratoId) {
		List<NttDataContrato> listContracts = null;
		if(nameCliente!=null && contratoId!=null) {
			listContracts = contratoDao.searchByNameClienteAndIdContrato(nameCliente, contratoId);
		}
		return listContracts ;
	}

}
