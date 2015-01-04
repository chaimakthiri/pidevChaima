package com.esprit.pidev.crud;


import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Result;

@Local
@Path("/res")
public interface ManageReservationServiceLocal {
	@GET
	@Path("/addres/{u}/{s}")
	@Produces(MediaType.APPLICATION_XML)
	public Result AddReservation(@PathParam("u")int iduser,@PathParam("s")int idservice);
}
