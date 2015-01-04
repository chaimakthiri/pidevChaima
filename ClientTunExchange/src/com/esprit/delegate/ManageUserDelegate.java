package com.esprit.delegate;

import java.util.List;

import com.esprit.pidev.crud.ManageUserRemote;
import com.esprit.pidev.jpa.Customer;
import com.esprit.pidev.jpa.User;
import com.esprit.serviceLocator.ServiceLocator;

public class ManageUserDelegate {

	@SuppressWarnings("unused")
	private static ManageUserRemote m;
	public static ManageUserRemote getRemote(){
		ManageUserRemote m= (ManageUserRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageUser!com.esprit.pidev.crud.ManageUserRemote");

	return m;
	}

	public static void addUser(User user) {
		getRemote().addUser(user);
		
	}


	public static Customer findById(int id) {
		// TODO Auto-generated method stub
		return getRemote().findById(id);
	}


	public static  void updateUser(User user) {
	getRemote().updateUser(user);
		
	}
	


	public static  void deleteCustomer(Customer Customer) {
		getRemote().deleteCustomer(Customer);
	}
	
	
	public static List<Customer> afficheCustomers(){
		return getRemote().afficheCustomers();
	}
	public static List<Customer> searchCustomers(String firstName){
		return getRemote().searchCustomers(firstName);
	}
	public static  void updateCustomer(Customer Customer) {
		getRemote().updateUser(Customer);
			
		}
	
}
