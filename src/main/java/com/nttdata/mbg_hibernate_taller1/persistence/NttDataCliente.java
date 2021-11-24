package com.nttdata.mbg_hibernate_taller1.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ejercicio Hibernate [Taller 1]
 * 
 * Entidad Cliente
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */

@Entity
@Table(name = "CLIENTE")
public class NttDataCliente extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clienteId;

	/* Nombre */
	private String name;

	/* PrimerApellido */
	private String firstSurname;

	/* SegundoApellido */
	private String secondSurname;

	/* DNI */
	private String dni;
	
	/**/
	List<NttDataContrato> contratos;

	/**
	 * @return clienteId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteid
	 *            cambiar el clienteId
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "NOMBRE")
	public String getName() {
		return name;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the primerApellido
	 */
	@Column(name = "PRIMER_APELLIDO")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * @return the segundoApellido
	 */
	@Column(name = "SEGUNDO_APELLIDO")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return DNI
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            cambiar el dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	

	/**
	 * @return the contratos
	 */
	@OneToMany(cascade= CascadeType.ALL, mappedBy="cliente")
	public List<NttDataContrato> getContratos() {
		return contratos;
	}

	/**
	 * @param contratos the contratos to set
	 */
	public void setContratos(List<NttDataContrato> contratos) {
		this.contratos = contratos;
	}

	@Override
	public String toString() {
		return "NttDataCliente [clienteId=" + clienteId + ", clienteNombre=" + name + ", clientePrimerApellido=" + firstSurname
		        + ", clienteSegundoApellido=" + secondSurname + ", dni=" + dni + "]";
	}

}