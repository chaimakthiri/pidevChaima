package com.esprit.models;

import java.util.List;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.pidev.jpa.Administrator;

@SuppressWarnings("serial")
public class RechercheAdmin extends AbstractTableModel {

	List<Administrator> list1;

	Administrator admin;
	Administrator admin1;

	private String[] columName = { "id", "firstName", "LastName", "E-Mail",
			"Phone", "Login", "Password" };

	@SuppressWarnings("unused")
	public RechercheAdmin(String nom) throws NamingException {
		Object obj;
		Administrator admin;
		Administrator admin1;

		for (int i = 0; i < 5; i++) {
			
			list1 = ManageAdministratorDelegate.findByFirstName1(nom);

		}

	}

	@Override
	public int getRowCount() {
		return list1.size();
	}

	@Override
	public int getColumnCount() {
		return columName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return list1.get(rowIndex).getIdAdmin();
		case 1:
			return list1.get(rowIndex).getFirstName();
		case 2:
			return list1.get(rowIndex).getLastName();
		case 3:
			return list1.get(rowIndex).getMail();
		case 4:
			return list1.get(rowIndex).getPhone();
		case 5:
			return list1.get(rowIndex).getLogin();
		case 6:
			return list1.get(rowIndex).getPassword();
		}
		return null;
	}

	public String getColumName(int column) {
		return columName[column];
	}

}
