package com.nttdata.mbg_hibernate_taller1.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Ejercicio Hibernate [Taller 1]
 * 
 * DAO de tabla CLIENTE
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public class NttDataClienteDaoImpl extends CommonDaoImpl<NttDataCliente> implements NttDataClienteDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public NttDataClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NttDataCliente> searchByNameAndSurname(String name, String firstSurname, String secondSurname) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y los apellidos.
		final List<NttDataCliente> listaClientes = session.createQuery("FROM NttDataCliente WHERE name='" + name+"' AND firstSurname='" +firstSurname+ "' AND secondSurname='" +secondSurname+"'").list();

		return listaClientes;
	}

	
	@Override
	public List<NttDataCliente> searchByDni(String dni) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<NttDataCliente> cquery = cb.createQuery(NttDataCliente.class);
		Root<NttDataCliente> rootP = cquery.from(NttDataCliente.class);
		
		cquery.select(rootP).where(cb.equal(rootP.<String> get("dni"), dni));
		final List<NttDataCliente> results = session.createQuery(cquery).getResultList();
		
		return results;
	}

}
