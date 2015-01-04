package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity
@XmlRootElement
public class Service implements Serializable {

	   
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idService;
	@XmlTransient
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String name;
	private String description;
	private Float note;
	private int prixToken;
	private boolean etat;
	private int nbVote;
	private float moyenne;
	@OneToMany(mappedBy="service")
	private List<Comment> comment;
	@XmlTransient
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	public int getNbVote() {
		return nbVote;
	}
	public void setNbVote(int nbVote) {
		this.nbVote = nbVote;
	}

	@ManyToOne
	private Category category ;
	@Override
	public String toString() {
		return "Service [idService=" + idService + ", name=" + name
				+ ", description=" + description + ", note=" + note
				+ ", prixToken=" + prixToken + ", etat=" + etat + ", nbVote="
				+ nbVote + ", moyenne=" + moyenne + ", category=" + category
				+ ", user=" + user + "]";
	}
	@XmlTransient
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	

	public Service() {
		super();
	}   
	public int getIdService() {
		return this.idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Float getNote() {
		return this.note;
	}

	public void setNote(Float note) {
		this.note = note;
	}   
	
	public int getPrixToken() {
		return this.prixToken;
	}

	public void setPrixToken(int prixToken) {
		this.prixToken = prixToken;
	}
   
}
