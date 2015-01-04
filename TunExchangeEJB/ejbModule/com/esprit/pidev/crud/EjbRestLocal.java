package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.ReservationService;
import com.esprit.pidev.jpa.Service;
import com.esprit.pidev.jpa.User;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

@Local
@Path("/TunExchange")
public interface EjbRestLocal {
	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String Helloword();

	@GET
	@Path("/authentificate/{login}/{password}")
	@Produces("text/plain")
	public boolean authentificate(@PathParam("login")String login,@PathParam("password")String password);
	//affiche User
	@GET
	@Path("/showUser/{id}")
	@Produces("application/xml") 
	public User afficherUser(@PathParam("id")int id);
	
	//affiche service
	@GET
	@Path("/showService/{id}")
	@Produces("application/xml") 
	public List<Service> afficherService(@PathParam("id")int id);
	
	//affiche servicereservé
	@GET
	@Path("/showServiceReserve/{id}")
	@Produces("application/xml") 
	public List<ReservationService> afficherServiceReserve(@PathParam("id")int id); 
	
	//supprimer un service
	@DELETE
	@Path("/DeleteService/{idService}")
	public void DeleteService(@PathParam("idService")int id);
	
	
	
}
