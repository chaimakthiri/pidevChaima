package com.esprit.pidev.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.ReservationService;
import com.esprit.pidev.jpa.Result;
import com.esprit.pidev.jpa.Service;
import com.esprit.pidev.jpa.User;

/**
 * Session Bean implementation class ManageReservationService
 */
@Stateless
public class ManageReservationService implements ManageReservationServiceRemote, ManageReservationServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public ManageReservationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Result AddReservation(int iduser, int idservice) {
		Result r=new Result();
		ReservationService rs=new ReservationService();
		User u=em.find(User.class, iduser);
		Service s=em.find(Service.class, idservice);
		if(u.getSoldeToken()>s.getPrixToken()){
			u.setSoldeToken(u.getSoldeToken()-s.getPrixToken());
		rs.setUser(u);
		rs.setService(s);
		rs.setEtat(false);
		try {
			em.persist(rs);
			em.merge(u);
			r.setRes("true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setRes("false");
		}
		}else {
			r.setRes("solde insuffisant");
		}
		return r;
	}

}
