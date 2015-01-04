package com.esprit.pidev.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@XmlRootElement
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	private String nameCategory;

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory="
				+ nameCategory + ", services=" + services + "]";
	}
	@XmlTransient
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@OneToMany(mappedBy = "category", cascade=CascadeType.REMOVE)
	private List<Service> services;
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
