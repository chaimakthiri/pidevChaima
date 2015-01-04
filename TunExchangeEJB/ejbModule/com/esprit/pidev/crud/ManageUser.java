package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.pidev.jpa.Customer;
import com.esprit.pidev.jpa.User;

/**
 * Session Bean implementation class ManageUser
 */
@Stateless
@LocalBean
public class ManageUser implements ManageUserRemote, ManageUserLocal {

	@PersistenceContext(unitName="TunExchange")
	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public ManageUser() {
       
    }

	@Override
	public void addUser(User user) {
		em.persist(user);
		
	}

	@Override
	public Customer findById(int id) {
		
		return em.find(Customer.class, id);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
		
	}

	@Override
	public void deleteCustomer(Customer Customer) {

		em.remove(em.merge(Customer));
		}

	@Override
	public List<Customer> afficheCustomers() {
		List<Customer> customers;
		customers= em.createQuery("SELECT c FROM Customer c",Customer.class).getResultList();
		
	//	System.out.println("---------------"+customers.size());
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchCustomers(String firstName) {
    Query query=em.createQuery("SELECT c FROM Customer c  where c.firstName like :firstName").setParameter("firstName", "%"+firstName+"%");
		
		
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void updateCustomer(Customer Customer) {
		em.merge(Customer);
		
	}

	public User authenticate(String login) {
		javax.persistence.Query q =em.createQuery("select a from User a" +
				" where a.login=:p1 ").setParameter("p1", login);
				
User u=new User();
			try {
				u = (User) q.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
					return u;
	}

	
		
	}
	
	

