package com.esprit.pidev.jpa;

import com.esprit.pidev.jpa.Service;
import com.esprit.pidev.jpa.User;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationService
 *
 */
@Entity

public class ReservationService implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int Id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUser",referencedColumnName="idUser")
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idService",referencedColumnName="idService")
	private Service service;
	private boolean Etat;
	private static final long serialVersionUID = 1L;

	public ReservationService() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}   
	public boolean getEtat() {
		return this.Etat;
	}

	public void setEtat(boolean Etat) {
		this.Etat = Etat;
	}
   
}
