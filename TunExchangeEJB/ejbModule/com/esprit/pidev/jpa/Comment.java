package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
@XmlRootElement
public class Comment implements Serializable {

	   
	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", description="
				+ description + ", user=" + user + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idComment;
	private String description;
	@ManyToOne
	private User user ;
	@ManyToOne
	private Service service;
	private static final long serialVersionUID = 1L;
    
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Comment() {
		super();
	}   
	public int getIdComment() {
		return this.idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
