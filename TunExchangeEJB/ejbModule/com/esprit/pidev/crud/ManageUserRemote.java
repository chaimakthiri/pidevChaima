package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Customer;
import com.esprit.pidev.jpa.User;

;

@Remote
public interface ManageUserRemote {
	public void addUser(User user);

	public Customer findById(int id);

	public void updateUser(User user);

	public void deleteCustomer(Customer Customer);
	
	public List<Customer> afficheCustomers();
    
	public List<Customer> searchCustomers(String firstName);
	
	public void updateCustomer(Customer Customer);
	
	
} 
