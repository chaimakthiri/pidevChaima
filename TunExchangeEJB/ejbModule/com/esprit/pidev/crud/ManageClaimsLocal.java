package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;


@Local
@Path("/claims")
public interface ManageClaimsLocal {
	@GET
	@Path("/report/{content}/{email}/{subject}")
	@Produces(MediaType.APPLICATION_XML )
	public Claims reportClaims(@PathParam("content")String content,@PathParam("email")String email,@PathParam("subject")String subject);
	public void add(Claims c);
	public void update(Claims c);
	public void Delete(int id);
	public Claims getClaimsbyid(int id);
	public List<Claims> getallClaims();
	public List<Claims> getnotresponse();
	public List<Claims> findclaimbyname(String name);
	public String getnbClaims();
	public void Sendmailresult(String to,String subject,String text);
	public ResponseClaims getResponse(int idClaimss);

}
