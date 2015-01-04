package com.esprit.pidev.crud;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.User;

@Local
@Path("/user")
public interface ManageUserLocal {

		@GET
		@Path("/authenticate/{login}")
		@Produces(MediaType.APPLICATION_XML)
		public User authenticate(@PathParam("login")String login);

}
