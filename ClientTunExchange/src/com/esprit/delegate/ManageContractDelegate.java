package com.esprit.delegate;

import java.util.List;



import com.esprit.pidev.crud.ManageContractRemote;
import com.esprit.pidev.jpa.Contract;
import com.esprit.serviceLocator.ServiceLocator;

public class ManageContractDelegate {
	@SuppressWarnings("unused")
	private static ManageContractRemote m;
	private static ManageContractRemote getRemote(){
		ManageContractRemote m=(ManageContractRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageContract!com.esprit.pidev.crud.ManageContractRemote");

	return m;
	}
	
	public static void addContract(Contract contract) {
		getRemote().addContract(contract);
		
	}


	public static Contract findById(int id) {
		return getRemote().findById(id);
	}


	public static  void update(Contract contract) {
	getRemote().update(contract);
		
	}


	public static  void delete(Contract contract) {
		getRemote().delete(contract);
	}
	
	public static List<Contract> afficheContract(){
		
		return getRemote().afficheContract();
	}
}
