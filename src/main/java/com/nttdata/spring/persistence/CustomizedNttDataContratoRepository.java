package com.nttdata.spring.persistence;

import java.util.List;

public interface CustomizedNttDataContratoRepository {

	/**
	 * Busca el contrato que tiene asociado el cliente que le pasamos como parametros
	 * 
	 * @param clienteId
	 * @return List<NttDataContrato>
	 * */
	public List<NttDataContrato> searchByIdCliente(final Long clienteId);
}
