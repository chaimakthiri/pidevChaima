package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;

@Remote
public interface ManageResponseClaimsRemote {
	public void add(ResponseClaims r);
	public void update(ResponseClaims r);
	public ResponseClaims getClaimsbyid(int id);
	public ResponseClaims getClaimsbyclaims(Claims c);
	public List<ResponseClaims> getallResponseClaims();
	public ResponseClaims refresh(ResponseClaims r);
}
