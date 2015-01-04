package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Campany
 *
 */
@Entity
@XmlRootElement
public class Campany extends User implements Serializable {

	   
	
	@Override
	public String toString() {
		return "Campany [name=" + name + ", matricule=" + matricule
				+ ", contrat=" + contrat + "]";
	}
	//private boolean status;
	private String name;
	private String matricule;
	@OneToOne(cascade=CascadeType.ALL)
	private Contract contrat;
	public Contract getContrat() {
		return contrat;
	}

	public void setContrat(Contract contrat) {
		this.contrat = contrat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public Campany() {
		super();
	}   
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
   
}
