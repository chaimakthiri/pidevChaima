package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Administrator;

@Remote
public interface ManageAdministratorRemote {
	public Administrator authenticate(String login,String password);
	public Administrator findById(int idAdmin);
	public void addAdmin(Administrator administrator);
	public List<Administrator> afficherAdmin();
	public void DeleteAdminnistrator(int id);
	public Administrator findByFirstName(String firstName);
	public List<Administrator> findByFirstName1(String firstName);
	public void DeleteAll(List<Administrator> list);
}
