package com.nttdata.mbg_hibernate_taller1.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class NttDataContratoDaoImpl extends CommonDaoImpl<NttDataContrato> implements NttDataContratoDaoI {
	/** Sesión de conexión a BD */
	private Session session;

	/* Constructor */
	public NttDataContratoDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NttDataContrato> searchByIdCliente(final Long clienteId) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		//Localiza contratos en funcion del ID select * from t_contratos where clienteId_FK = ?
		final List<NttDataContrato> listContratos = session.createQuery("FROM NttDataContrato WHERE cliente.clienteId=" + clienteId).list();

		
		return listContratos;
	}

	@Override
	public List<NttDataContrato> searchByNameClienteAndIdContrato(String nameCliente, Long contratoId) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<NttDataContrato> cquery = cb.createQuery(NttDataContrato.class);
		Root<NttDataContrato> rootP = cquery.from(NttDataContrato.class);
		Join<NttDataContrato, NttDataCliente> pJoinT = rootP.join("cliente");
		//Where
		Predicate pr1 = cb.equal(pJoinT.getParent().<Long> get("contratoId"), contratoId);
		Predicate pr2 = cb.equal(pJoinT.get("name"), nameCliente);
		
		cquery.select(rootP).where(cb.and(pr1, pr2));
		List<NttDataContrato> results = session.createQuery(cquery).getResultList();
		
		return results;
	}

}
