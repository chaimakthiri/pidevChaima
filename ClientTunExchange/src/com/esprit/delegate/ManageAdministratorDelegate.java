package com.esprit.delegate;


import java.security.*;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.esprit.pidev.crud.ManageAdministratorRemote;
import com.esprit.pidev.jpa.Administrator;
import com.esprit.serviceLocator.ServiceLocator;

/**
 * Session Bean implementation class ManageCustomer
 */
@Stateless
@LocalBean
public class ManageAdministratorDelegate {
private static ManageAdministratorRemote getRemote(){
	ManageAdministratorRemote m=(ManageAdministratorRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEAR/TunExchangeEJB/ManageAdministrator!com.esprit.pidev.crud.ManageAdministratorRemote");
return m;
}

public static String getEncodedPassword(String key) {
	  byte[] uniqueKey = key.getBytes();
	  byte[] hash = null;
	  try {
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	  } catch (NoSuchAlgorithmException e) {
		throw new Error("no MD5 support in this VM");
	  }
	  StringBuffer hashString = new StringBuffer();
	  for ( int i = 0; i < hash.length; ++i ) {
		String hex = Integer.toHexString(hash[i]);
		if ( hex.length() == 1 ) {
		  hashString.append('0');
		  hashString.append(hex.charAt(hex.length()-1));
		} else {
		  hashString.append(hex.substring(hex.length()-2));
		}
	  }
	  return hashString.toString();
	}


public static Administrator authentificate(String login,String password) {
	// TODO Auto-generated method stub
	return getRemote().authenticate(login, getEncodedPassword(password));
}

public Administrator findById(int idAdmin) {
	return getRemote().findById(idAdmin);
}

public static List<Administrator> afficherAdmin(){
	return getRemote().afficherAdmin();
}


public static  void DeleteAdminnistrator(int id) {
	getRemote().DeleteAdminnistrator(id);
}

public static void DeleteAll(List<Administrator> list) {
	getRemote().DeleteAll(list);
}

public static List<Administrator> findByFirstName1(String firstName) {
	return getRemote().findByFirstName1(firstName);
}

public static void addAdmin(Administrator administrator) {
	getRemote().addAdmin(administrator);
}

}
