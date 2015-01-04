package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.pidev.jpa.Contract;

/**
 * Session Bean implementation class ManageContract
 */
@Stateless
@LocalBean
public class ManageContract implements ManageContractRemote, ManageContractLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="TunExchange")
	private EntityManager em;
    public ManageContract() {

    }
    
    @Override
	public void addContract(Contract contract) {
		em.persist(contract);
		
	}

	@Override
	public void delete(Contract contract) {
		em.remove(em.merge(contract));
		
	}

	@Override
	public void update(Contract contract) {
		em.merge(contract);
		
	}

	@Override
	public Contract findById(int id) {
		return em.find(Contract.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> afficheContract() {
		Query q= em.createQuery("SELECT u FROM Campany u");
		List<Contract>c=q.getResultList();
		return c;
	}

}
