package com.nttdata.spring.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ejercicio Hibernate & JPA [Taller 1, Taller 2 y Taller 3]
 * 
 * Interdaz NttDataContratoDao
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
@Repository
public interface NttDataContratoRepository extends JpaRepository<NttDataContrato, Long>, CustomizedNttDataContratoRepository{

	
}
