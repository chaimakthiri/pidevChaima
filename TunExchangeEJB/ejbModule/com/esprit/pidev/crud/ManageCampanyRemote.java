package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Campany;

@Remote
public interface ManageCampanyRemote {
	public void addCampany(Campany campany);
	public void delete(Campany campany);
	public void update(Campany campany);
	public Campany findById(int id);
	public List<Campany> afficheCampany();
}
