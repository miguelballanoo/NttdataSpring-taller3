package com.nttdata.spring.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomizedNttDataContratoRepositoryImpl implements CustomizedNttDataContratoRepository {
	@Autowired 
	EntityManager em;

	@Override
	public List<NttDataContrato> searchByIdCliente(Long clienteId) {

		// Localiza contratos en funcion del ID select * from t_contratos where clienteId_FK = ?
		final List<NttDataContrato> listContratos = em.createQuery("FROM NttDataContrato WHERE cliente.clienteId=" + clienteId).getResultList();

		return listContratos;
	}

}
