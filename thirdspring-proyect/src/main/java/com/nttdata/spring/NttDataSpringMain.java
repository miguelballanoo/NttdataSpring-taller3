package com.nttdata.spring;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.spring.persistence.NttDataCliente;
import com.nttdata.spring.persistence.NttDataContrato;
import com.nttdata.spring.services.NttDataClienteGestionServicioI;
import com.nttdata.spring.services.NttDataContratoGestionServicioI;

@SpringBootApplication
public class NttDataSpringMain implements CommandLineRunner {

	@Autowired
	private NttDataClienteGestionServicioI servicioCliente;
	@Autowired
	private NttDataContratoGestionServicioI servicioContrato;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
		List<NttDataCliente> clientes = servicioCliente.findByNameAndFirstSurname("Miguel", "Ballano");
		System.out.println("CONSULTA 1 ==> ");
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

		// Consulta 2 (Consulta compleja no recojida por los metodos de Spring Data)
		List<NttDataContrato> contratos = servicioContrato.searchClienteById((long) 1);
		System.out.println("CONSULTA 2 ==> ");
		for (final NttDataContrato contrato : contratos) {// Recorrido de los contratos encontrados
			System.out.println(contrato.toString());
		}
		
		// Consulta 3
		List<NttDataCliente> clientesJPA = servicioCliente.searchByDni("49167587G");
		for (final NttDataCliente cliente : clientesJPA) {// Recorrido de los clientes encontrados
			System.out.println(cliente.toString());
		}

		
		

	}

}
