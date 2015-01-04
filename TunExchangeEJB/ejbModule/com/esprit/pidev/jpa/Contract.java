package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity
@XmlRootElement
public class Contract implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idContract;
	public Campany getCampany() {
		return campany;
	}
	public void setCampany(Campany campany) {
		this.campany = campany;
	}
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Temporal(TemporalType.DATE)
	private Date dateCreat;
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	private float prix;
	@OneToOne
	private Campany campany;
	@ManyToOne
	private Administrator administrator;
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

	private static final long serialVersionUID = 1L;

	public Contract() {
		super();
	}   
	public int getIdContract() {
		return this.idContract;
	}

	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}   
	public Date getDateCreat() {
		return this.dateCreat;
	}

	public void setDateCreat(Date dateCreat) {
		this.dateCreat = dateCreat;
	}
   
}
