package com.esprit.delegate;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.esprit.pidev.crud.ManageResponseClaimsRemote;
import com.esprit.pidev.jpa.Claims;
import com.esprit.pidev.jpa.ResponseClaims;
import com.esprit.serviceLocator.ServiceLocator;

/**
 * Session Bean implementation class ManageCustomer
 */
@Stateless
@LocalBean
public class ManageResponseClaimsDelegate {
private static ManageResponseClaimsRemote getRemote(){
	ManageResponseClaimsRemote m=(ManageResponseClaimsRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageResponseClaims!com.esprit.pidev.crud.ManageResponseClaimsRemote");

return m;
}

public ResponseClaims getResponseClaimsbyclaims(Claims claims) {
	return getRemote().getClaimsbyclaims(claims);
}


public void add(ResponseClaims r) {
	getRemote().add(r);
	
}

public void update(ResponseClaims r) {
	getRemote().update(r);
	
}

public ResponseClaims getResponseClaimsbyid(int idResponse) {


	return getRemote().getClaimsbyid(idResponse);
}

public List<ResponseClaims> getallResponseClaims() {
	return getRemote().getallResponseClaims();
}

public ResponseClaims refresh(ResponseClaims r) {
	getRemote().refresh(r);
	return r;
}


}
