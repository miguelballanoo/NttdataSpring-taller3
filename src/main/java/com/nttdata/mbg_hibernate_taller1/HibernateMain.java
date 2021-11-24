package com.nttdata.mbg_hibernate_taller1;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.mbg_hibernate_taller1.persistence.NttDataCliente;
import com.nttdata.mbg_hibernate_taller1.persistence.NttDataContrato;
import com.nttdata.mbg_hibernate_taller1.services.NttDataClienteGestionServicioI;
import com.nttdata.mbg_hibernate_taller1.services.NttDataClienteGestionServicioImpl;
import com.nttdata.mbg_hibernate_taller1.services.NttDataContratoGestionServicioI;
import com.nttdata.mbg_hibernate_taller1.services.NttDataContratoGestionServicioImpl;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Clase MAIN
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
public class HibernateMain {
	public static void main(String[] args) {
		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NttDataClienteGestionServicioI servicioCliente = new NttDataClienteGestionServicioImpl(session);
		final NttDataContratoGestionServicioI servicioContrato = new NttDataContratoGestionServicioImpl(session);

		// Auditoría.
		final String updatedUser = "BALLANO_SYS";
		final Date updatedDate = new Date();

		// Generación de cliente
		final NttDataCliente cliente1 = new NttDataCliente();
		cliente1.setName("Miguel");
		cliente1.setFirstSurname("Ballano");
		cliente1.setSecondSurname("Garduño");
		cliente1.setDni("49167587G");
		cliente1.setUpdatedDate(updatedDate);
		cliente1.setUpdatedUser(updatedUser);

		// Se añade el cliente que se ha creado al servicio
		servicioCliente.addCliente(cliente1);

		// Consulta 1
		List<NttDataCliente> clientes = servicioCliente.searchByNameAndSurname("Miguel", "Ballano", "Garduño");
		for (final NttDataCliente cliente : clientes) {
			System.out.println(cliente.toString());
		}

		// Generacion de contrato
		final NttDataContrato contrato1 = new NttDataContrato();
		contrato1.setDateValidity(new Date(121, 11, 18));
		contrato1.setDateExpiration(new Date(122, 11, 18));
		contrato1.setPrice(99);
		contrato1.setCliente(cliente1);
		contrato1.setUpdatedDate(updatedDate);
		contrato1.setUpdatedUser(updatedUser);

		// Se añade el contrato que se ha creado al servicio
		servicioContrato.addContrato(contrato1);

		// Consulta 2
		List<NttDataContrato> contratos = servicioContrato.searchClienteById((long) 1);
		for (final NttDataContrato contrato : contratos) {//Recorrido de los contratos encontrados
			System.out.println(contrato.toString());
		}

		//Consulta 3
		List<NttDataCliente> clientesJPA = servicioCliente.searchByDni("49167587G");
		for (final NttDataCliente cliente : clientesJPA) {//Recorrido de los clientes encontrados
			System.out.println(cliente.toString());
		}

		// Consulta 4
		List<NttDataContrato> contratosJPA = servicioContrato.searchByNameClienteAndIdContrato("Miguel", (long) 1);
		for (final NttDataContrato contrato : contratosJPA) {//Recorrido de los contratos encontrados
			System.out.println(contrato.toString());
		}
		
		
		// Cierre de sesion
		session.close();
	}
}
