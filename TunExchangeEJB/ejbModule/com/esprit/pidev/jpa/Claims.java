package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Claims
 *
 */
@Entity
@XmlRootElement
public class Claims implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idClaims;
	private String subject;
	private String name;
	private String email;
	private String content;
	private boolean etat;
	private Date date ;
	@OneToOne(mappedBy ="claims", cascade = CascadeType.ALL)
	private ResponseClaims responseClaims ;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	private static final long serialVersionUID = 1L;

	public Claims() {
		super();
	}   
	public int getIdClaims() {
		return this.idClaims;
	}

	public void setIdClaims(int idClaims) {
		this.idClaims = idClaims;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public boolean getEtat() {
		return this.etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
   
}
