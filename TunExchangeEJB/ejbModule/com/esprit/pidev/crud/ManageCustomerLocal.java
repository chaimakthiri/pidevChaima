package com.esprit.pidev.crud;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Customer;

@Local
@Path("/register")
public interface ManageCustomerLocal {
	@GET
	@Path("/Application/{firstName}/{lastName}/{email}/{login}/{password}/{adresse}/{phone}/{fax}")
	@Produces(MediaType.APPLICATION_XML )
	public Customer registerCustomer(@PathParam("firstName")String firstName,@PathParam("lastName")String lastName,@PathParam("email")String email,@PathParam("login")String login,@PathParam("password")String password,@PathParam("adresse")String adresse,@PathParam("phone")String phone,@PathParam("fax")String fax);


}
