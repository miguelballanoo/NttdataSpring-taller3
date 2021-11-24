package com.nttdata.mbg_hibernate_taller1.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Ejercicio Hibernate [Taller 2]
 * 
 * Entidad Contrato
 * 
 * @author Miguel Ángel Ballano Garduño
 *
 */
@Entity
@Table(name="CONTRATO")
public class NttDataContrato extends AbstractEntity implements Serializable{
	
		
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Identificador (PK) */
	private Long contratoId;
	
	/*Fecha de vigencia*/
	private Date dateValidity;
	
	/*Fecha de caducidad*/
	 private Date dateExpiration;
	
	/*Precio mensual*/
	private long price;
	
	/*Relacion con el cliente*/
	private NttDataCliente cliente;

	/**
	 * @return the contratoId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getContratoId() {
		return contratoId;
	}

	/**
	 * @param contratoId the contratoId to set
	 */
	public void setContratoId(Long contratoId) {
		this.contratoId = contratoId;
	}

	/**
	 * @return the dateValidity
	 */
	@Column(name = "FECHA_VIGENCIA")
	public Date getDateValidity() {
		return dateValidity;
	}

	/**
	 * @param dateValidity the dateValidity to set
	 */
	public void setDateValidity(Date dateValidity) {
		this.dateValidity = dateValidity;
	}

	/**
	 * @return the dateExpiration
	 */
	@Column(name = "FECHA_CADUCIDAD")
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * @param dateExpiration the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the price
	 */
	@Column(name = "PRECIO")
	public long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * @return the cliente
	 */
	@ManyToOne
	@JoinColumn(name="clienteId_FK")
	public NttDataCliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(NttDataCliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "NttDataContrato [contratoId=" + contratoId + ", dateValidity=" + dateValidity + ", dateExpiration=" + dateExpiration + ", price=" + price
		        + ", cliente=" + cliente + "]";
	}
	
		
	
	
}
