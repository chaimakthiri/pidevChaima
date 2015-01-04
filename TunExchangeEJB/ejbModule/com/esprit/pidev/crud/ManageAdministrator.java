package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.Administrator;

import javax.persistence.Query;


/**
 * Session Bean implementation class ManageAdministrator
 */
@Stateless
@LocalBean
public class ManageAdministrator implements ManageAdministratorRemote, ManageAdministratorLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public ManageAdministrator() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    @SuppressWarnings("unchecked")
	@Override
	public Administrator authenticate(String login, String password) {
		javax.persistence.Query q =em.createQuery("select a from Administrator a" +
				" where a.login=:p1 and a.password=:p2").setParameter("p1", login)
				.setParameter("p2", password);

				List<Administrator> results = q.getResultList();
				results.add(new Administrator(-1));
				
					return results.get(0);
			
	}
    /* (non-Javadoc)
	 * @see com.esprit.pidev.crud.AdministratorManagerRemote#authenticate(java.lang.String,
	 *  java.lang.String)
	 */



	@Override
	public Administrator findById(int idAdmin) {
		return em.find(Administrator.class, idAdmin);
	}
	
	@Override
	public void addAdmin(Administrator administrator) {
		em.persist(administrator);
	}

	@Override
	public List<Administrator> afficherAdmin() {
		Query query = em.createQuery("SELECT a FROM Administrator a");
		@SuppressWarnings("unchecked")
		List<Administrator> listAdmin = query.getResultList();
		return listAdmin;
	}



	@Override
	public void DeleteAdminnistrator(int id) {

		em.remove(findById(id));

	}
	
	

	@Override
	public Administrator findByFirstName(String firstName) {
		Administrator admin;
		Query query = em
				.createQuery("SELECT a FROM Administrator a  WHERE  a.firstName= ?");
				query.setParameter(1, firstName);
		admin = (Administrator) query.getSingleResult();
		
		return admin;

	}

@SuppressWarnings("unchecked")
@Override
	public List<Administrator> findByFirstName1(String firstName) {
		List<Administrator> list = null;
		Query query = em
				.createQuery("SELECT a FROM Administrator a  WHERE  a.firstName Like :fn");
				query.setParameter("fn","%"+firstName+"%");
		list= query.getResultList();
		
		
		
		return list;
	}

	
@Override
public void DeleteAll(List<Administrator> list) {
	for (Administrator admin : list)
		em.remove(em.merge(admin));
}
	

}
