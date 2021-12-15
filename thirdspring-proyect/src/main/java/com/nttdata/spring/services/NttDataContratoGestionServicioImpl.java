package com.nttdata.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.NttDataContrato;
import com.nttdata.spring.persistence.NttDataContratoRepository;

@Service
public class NttDataContratoGestionServicioImpl implements NttDataContratoGestionServicioI {

	@Autowired
	private NttDataContratoRepository contratoRepository;
	
	@Override
	public void addContrato(NttDataContrato newContrato) {
		if (newContrato != null && newContrato.getContratoId() == null) {
			contratoRepository.save(newContrato);
		}

	}

	@Override
	public List<NttDataContrato> searchAll() {
		List<NttDataContrato> listaContratos = new ArrayList<NttDataContrato>();

		// Obtención de contratos.
		listaContratos = contratoRepository.findAll();

		return listaContratos;
	}

	@Override
	public NttDataContrato searchById(Long contratoId) {
		// Resultado.
		Optional<NttDataContrato> contrato = null;

		// Verificación de nulidad.
		if (contratoId != null) {

			// Obtención del contrato por ID.
			contrato = contratoRepository.findById(contratoId);
		}

		return contrato.get();
	}

	@Override
	public void deleteContrato(NttDataContrato contratoAEliminar) {
		if (contratoAEliminar != null && contratoAEliminar.getContratoId() == null) {
			contratoRepository.delete(contratoAEliminar);
		}

	}

	@Override
	public void updateContrato(NttDataContrato contratoActualizado) {
		if (contratoActualizado != null && contratoActualizado.getContratoId() == null) {
			contratoRepository.save(contratoActualizado);
		}

	}

	@Override
	public List<NttDataContrato> searchClienteById(long clienteId) {
		List<NttDataContrato> listaContratos = new ArrayList<NttDataContrato>();

		// Obtención de contratos.
		listaContratos = contratoRepository.searchByIdCliente(clienteId);

		return listaContratos;
	}

}
