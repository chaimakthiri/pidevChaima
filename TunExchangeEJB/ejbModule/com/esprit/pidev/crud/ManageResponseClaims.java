package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;

/**
 * Session Bean implementation class ManageResponseClaims
 */
@Stateless
public class ManageResponseClaims implements ManageResponseClaimsRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public ManageResponseClaims() {
    	
    }

	@Override
	public void add(ResponseClaims r) {
		em.persist(r);
		
	}

	@Override
	public void update(ResponseClaims r) {
		em.merge(r);
		
	}

	@Override
	public ResponseClaims getClaimsbyid(int idResponse) {
		return em.find(ResponseClaims.class, idResponse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResponseClaims> getallResponseClaims() {
		return em.createQuery("SELECT r FROM ResponseClaims r").getResultList();
	}

	@Override
	public ResponseClaims refresh(ResponseClaims r) {
		em.flush();
		return (ResponseClaims) em.createQuery("SELECT r FROM ResponseClaims r WHERE r.content=:p1 and r.admin=:p2").setParameter("p1", r.getContent()).setParameter("p2", r.getAdmin()).getSingleResult();
		
	}

	@Override
	public ResponseClaims getClaimsbyclaims(Claims claims) {
		return (ResponseClaims) em.createQuery("SELECT r FROM ResponseClaims r where r.claims=:p1").setParameter("p1", claims).getSingleResult();
	}


}
