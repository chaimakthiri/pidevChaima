package com.esprit.models;

import java.util.List;

import javax.naming.InitialContext;
import javax.swing.table.AbstractTableModel;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.pidev.jpa.Administrator;

@SuppressWarnings("serial")
public class TableAdmin extends AbstractTableModel {
	List<Administrator> listAdmin;
	private String[] columName = { "id", "firstName", "LastName", "E-Mail",
			"Phone", "Login", "Password" };

	InitialContext ctx;

	public TableAdmin() {

		listAdmin = ManageAdministratorDelegate.afficherAdmin();

	}

	@Override
	public int getRowCount() {

		return listAdmin.size();
	}

	@Override
	public int getColumnCount() {
		return columName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listAdmin.get(rowIndex).getIdAdmin();
		case 1:
			return listAdmin.get(rowIndex).getFirstName();
		case 2:
			return listAdmin.get(rowIndex).getLastName();
		case 3:
			return listAdmin.get(rowIndex).getMail();
		case 4:
			return listAdmin.get(rowIndex).getPhone();
		case 5:
			return listAdmin.get(rowIndex).getLogin();
		case 6:
			return listAdmin.get(rowIndex).getPassword();

		}
		return null;

	}

	public String getColumName(int column) {
		return columName[column];
	}

}
