package com.esprit.delegate;


import java.util.List;



import com.esprit.pidev.crud.ManageCategoryRemote;
import com.esprit.pidev.jpa.Category;
import com.esprit.serviceLocator.ServiceLocator;

public class ManageCategoryDelegate {
	@SuppressWarnings("unused")
	private static  ManageCategoryRemote  m;
	private static ManageCategoryRemote getRemote(){
		ManageCategoryRemote m =(ManageCategoryRemote) ServiceLocator.getInstance().getProxy("/TunExchange/ManageCategory!com.esprit.pidev.crud.ManageCategoryRemote");
	return m;
	}
  public static List<Category> afficheCategory(){
		return getRemote().afficheCategory();
	}
}
