package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Customer;


@Remote
public interface ManageCustomerRemote {
	public void addCustomer(Customer customer);
	public Customer findById(int id);
	public void update(Customer customer);
	public void delete(Customer customer);
	public List<Customer> aficheC();
	

}
