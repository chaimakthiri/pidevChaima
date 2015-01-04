package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idUser;

	@OneToMany(mappedBy="user")
	private List<Comment> comment;
	@XmlTransient
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlTransient
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@XmlTransient
	public List<Service> getServicesUser() {
		return servicesUser;
	}
	public void setServicesUser(List<Service> servicesUser) {
		this.servicesUser = servicesUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    private String firstName;
	private String phone;
	private String adresse;
	private String mail;
	private String fax;
	private int soldeToken;
	private String login;
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName
				+ ", phone=" + phone + ", adresse=" + adresse + ", mail="
				+ mail + ", fax=" + fax + ", soldeToken=" + soldeToken
				+ ", login=" + login + ", password=" + password + ", comments="
				+ comments + ", servicesUser=" + servicesUser + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private String password;
	@OneToMany(mappedBy="user")
	private List<Comment> comments ;
	@OneToMany(mappedBy="user")
	private List<Service> servicesUser;
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL)
	private List<ReservationService> reservationServices ;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getTelphone() {
		return this.phone;
	}

	public void setTelphone(String phone) {
		this.phone = phone;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}   
	public int getSoldeToken() {
		return this.soldeToken;
	}

	public void setSoldeToken(int soldeToken) {
		this.soldeToken = soldeToken;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
