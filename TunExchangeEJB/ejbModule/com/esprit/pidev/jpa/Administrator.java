package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@XmlRootElement
public class Administrator implements Serializable {

	   
	public Administrator(int idAdmin) {
		super();
		this.idAdmin = idAdmin;
	}
	@Override
	public String toString() {
		return "Administrator [idAdmin=" + idAdmin + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mail=" + mail + ", phone="
				+ phone + ", login=" + login + ", password=" + password
				+ ", contrats=" + contrats + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idAdmin;

	public List<Contract> getContrats() {
		return contrats;
	}
	public void setContrats(List<Contract> contrats) {
		this.contrats = contrats;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String firstName;
	private String lastName;
	private String mail;
	private String phone;
	private String login;
	private String password;
	
	@OneToMany(mappedBy="administrator")
	private List<Contract> contrats ;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}   
	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
