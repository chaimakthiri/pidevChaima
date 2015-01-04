package com.esprit.pidev.crud;

import java.util.List; 

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.ReservationService;
import com.esprit.pidev.jpa.Service;
import com.esprit.pidev.jpa.User;


/**
 * Session Bean implementation class EjbRest
 */
@Stateless
@LocalBean
public class EjbRest implements EjbRestLocal { 

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public EjbRest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean authentificate(String login, String password) {
	User user=	(User) em.createQuery("SELECT u From User u where u.login= ? and u.password= ?").setParameter(1, login).setParameter(2, password).getSingleResult();
	if(user == null)
		return false ;
	else
		System.out.println("accés autorisé");
		return true ;
		
	}

	@Override
	
	public String Helloword() {
		return "hello word";
	}

	@Override
	public  List<Service> afficherService(int id) {
	List<Service> services= em.createNamedQuery("GetAllUsers").setParameter("var", id).getResultList();
	System.out.println(services);
		return services;
	}

	

	@Override
	public void DeleteService(int id) {
		ReservationService s = em.find(ReservationService.class, id);
		em.remove(em.merge(s));
	} 

	@Override
	public List<ReservationService> afficherServiceReserve(int id) {
		List<ReservationService> services= em.createQuery("select ls from User u join u.reservationServices ls where u.idUser = ?").setParameter(1, id).getResultList();
		System.out.println(services);
		return services;
	}

	@Override
	public User afficherUser(int id) {
		
		return  (User) em.createQuery("Select u from User u where u.idUser = ? ").setParameter(1,id).getSingleResult();
	}

	
	

}
