package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;

@Remote
public interface ManageClaimsRemote {
	public void add(Claims c);
	public void update(Claims c);
	public Claims getClaimsbyid(int id);
	public List<Claims> getallClaims();
	public List<Claims> getnotresponse();
	public List<Claims> findclaimbyname(String name);
	public String getnbClaims();
	public ResponseClaims getResponse(int idClaims);

}
