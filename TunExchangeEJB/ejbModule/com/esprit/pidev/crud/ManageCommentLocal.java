package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
	
import javax.ws.rs.QueryParam;

import com.esprit.pidev.jpa.Comment;

@Local
@Path("/Comment")
public interface ManageCommentLocal {
	@GET
	@Path("/affComment/{id}")
	@Produces("application/xml")
	public List<Comment> afficheComment(@PathParam("id")int id);
	@GET
	@Path("/addComment")
    public void addComment(@QueryParam("iduser")int iduser,@QueryParam("idservice")int idservice,@QueryParam("description")String description);

}
	
