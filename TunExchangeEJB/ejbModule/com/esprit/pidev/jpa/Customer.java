package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Cusromer
 *
 */
@Entity
@XmlRootElement
public class Customer extends User implements Serializable  {

	   
	
	

	
	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + "]";
	}

	private String lastName;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
	

	   
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
   
}
