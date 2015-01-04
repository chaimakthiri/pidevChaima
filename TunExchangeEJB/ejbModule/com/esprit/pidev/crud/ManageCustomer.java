package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.esprit.pidev.jpa.Customer;

/**
 * Session Bean implementation class ManageCustomer
 */
@Stateless
@LocalBean
public class ManageCustomer implements ManageCustomerRemote, ManageCustomerLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="TunExchange")
	private EntityManager em;
    public ManageCustomer() {
        
    }

	@Override
	public void addCustomer(Customer customer) {
		em.persist(customer);
		
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		em.merge(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		em.remove(em.merge(customer));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> aficheC() {
		Query query=em.createQuery("select c from Customer c");
		List<Customer> c ;
		c=(List<Customer>) query;
		return c ;
	}

	@Override
	public Customer registerCustomer(String firstName, String lastName,
			String email, String login, String password, String adresse,
			String phone, String fax) {
		
Customer customer =new Customer();


	customer.setFirstName(firstName);
	customer.setLastName(lastName);
	customer.setMail(email);
	customer.setSoldeToken(0);
	customer.setLogin(login);
	customer.setPassword(password);
	customer.setAdresse(adresse);
	customer.setPhone(phone);
	customer.setFax(fax);
	
	 em.persist(customer);
	 return customer;
	}

}
