package com.nttdata.spring.persistence;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Clase HibernateUtil
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
@Repository
public interface NttDataClienteRepository extends JpaRepository<NttDataCliente, Long> {

	/*Consulta para buscar cliente por su nombre y su primer apellido*/
	public List<NttDataCliente> findByNameAndFirstSurname(String name, String firstSurname);

	/*Consulta para buscar un cliente por su dni*/
	public List<NttDataCliente> findByDni(String dni);
}
