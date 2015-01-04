package com.esprit.delegate;



import java.util.List;

import com.esprit.pidev.crud.ManageCustomerRemote;
import com.esprit.pidev.jpa.Customer;
import com.esprit.serviceLocator.ServiceLocator;

public class ManageCustomerDelegate {
@SuppressWarnings("unused")
private static ManageCustomerRemote m;
private static ManageCustomerRemote getRemote(){
	ManageCustomerRemote m=(ManageCustomerRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageCustomer!com.esprit.pidev.crud.ManageCustomerRemote");

return m;
}

public static void addCustomer(Customer customer) {
	getRemote().addCustomer(customer);
	
}


public static Customer findById(int id) {
	// TODO Auto-generated method stub
	return getRemote().findById(id);
}


public static  void update(Customer customer) {
getRemote().update(customer);
	
}


public static  void delete(Customer customer) {
	getRemote().delete(customer);
}
public static List<Customer> aficheC() {
	return getRemote().aficheC();
}
}
