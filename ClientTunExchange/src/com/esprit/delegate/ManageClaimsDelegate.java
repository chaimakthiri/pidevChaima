package com.esprit.delegate;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.esprit.pidev.crud.ManageClaimsRemote;
import com.esprit.pidev.jpa.Claims;
import com.esprit.serviceLocator.ServiceLocator;

/**
 * Session Bean implementation class ManageCustomer
 */
@Stateless
@LocalBean
public class ManageClaimsDelegate {
private static ManageClaimsRemote getRemote(){
	ManageClaimsRemote m=(ManageClaimsRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageClaims!com.esprit.pidev.crud.ManageClaimsRemote");

return m;
}




public void add(Claims c) {
	getRemote().add(c);
	
}

public void update(Claims c) {
	getRemote().update(c);
	
}

public Claims getClaimsbyid(int idClaims) {


	return getRemote().getClaimsbyid(idClaims);
}

public List<Claims> getallClaims() {
	return getRemote().getallClaims();
}

public List<Claims> getnotresponse() {
	return getRemote().getnotresponse();
}

public String getnbClaims() {
	return getRemote().getnbClaims();
}
public List<Claims> findclaimbyname(String name) {
	return getRemote().findclaimbyname(name);

}
}
