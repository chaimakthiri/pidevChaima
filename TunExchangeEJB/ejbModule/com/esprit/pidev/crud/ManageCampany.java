package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.pidev.jpa.Campany;

/**
 * Session Bean implementation class ManageCampany
 */
@Stateless
@LocalBean
public class ManageCampany implements ManageCampanyRemote, ManageCampanyLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="TunExchange")
	private EntityManager em;
    public ManageCampany() {
    }

	@Override
	public void addCampany(Campany campany) {
		em.persist(campany);
		
	}

	@Override
	public void delete(Campany campany) {
		em.remove(em.merge(campany));
		
	}

	@Override
	public void update(Campany campany) {
		em.merge(campany);
		
	}

	@Override
	public Campany findById(int id) {
		return em.find(Campany.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Campany> afficheCampany() {
		Query q= em.createQuery("SELECT u FROM Campany u");
		List<Campany>c=q.getResultList();
		return c;
	}

}
