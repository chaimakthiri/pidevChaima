package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: ResponseClaims
 *
 */
@Entity
@XmlRootElement
@NamedQuery(name="findResponse",query="Select r from ResponseClaims  r Join r.claims c where  c.idClaims= :id") 
public class ResponseClaims implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idResponse;
	private String content;
	@OneToOne(cascade=CascadeType.ALL)
	private Administrator admin;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idC")
	private Claims claims;
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Claims getClaims() {
		return claims;
	}
	public void setClaims(Claims claims) {
		this.claims = claims;
	}

	private static final long serialVersionUID = 1L;

	public ResponseClaims() {
		super();
	}   
	public int getIdResponse() {
		return this.idResponse;
	}

	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
   
}
