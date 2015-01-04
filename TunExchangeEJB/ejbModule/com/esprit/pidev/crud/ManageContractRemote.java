package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Contract;

@Remote
public interface ManageContractRemote {
	public 	void addContract(Contract contract);
	public	void delete(Contract contract);
	public	void update(Contract contract);
	public	Contract findById(int id);
	public	List<Contract> afficheContract();
}
