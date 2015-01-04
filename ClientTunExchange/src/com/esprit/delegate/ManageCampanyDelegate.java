package com.esprit.delegate;

import java.util.List;

import com.esprit.pidev.crud.ManageCampanyRemote;
import com.esprit.pidev.jpa.Campany;
import com.esprit.serviceLocator.ServiceLocator;

public class ManageCampanyDelegate {

	@SuppressWarnings("unused")
	private static ManageCampanyRemote m;
	private static ManageCampanyRemote getRemote(){
		ManageCampanyRemote m=(ManageCampanyRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageCampany!com.esprit.pidev.crud.ManageCampanyRemote");

	return m;
	}
	
	public static void addCampany(Campany campany) {
		getRemote().addCampany(campany);
		
	}


	public static Campany findById(int id) {
		return getRemote().findById(id);
	}


	public static  void update(Campany campany) {
	getRemote().update(campany);
		
	}


	public static  void delete(Campany campany) {
		getRemote().delete(campany);
	}
	
	public static List<Campany> afficheCampany(){
		
		return getRemote().afficheCampany();
	}
}
