package com.esprit.delegate;



import java.util.List;

import com.esprit.pidev.crud.ManageServiceRemote;
import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;
import com.esprit.serviceLocator.ServiceLocator;



public class ManageServiceDelegate {
	@SuppressWarnings("unused")
	private static  ManageServiceRemote  m;
	private static ManageServiceRemote getRemote(){
		ManageServiceRemote m =(ManageServiceRemote) ServiceLocator.getInstance().getProxy("/TunExchangeEJB/ManageService!com.esprit.pidev.crud.ManageServiceRemote");
	return m;
       
	}
	
	public static void addService(Service s){
		getRemote().addService(s);
	}
	public static Service findById(int id) {
		return getRemote().findById(id);
	}
	public static void update(Service s){
		getRemote().update(s);
		
	}
	public static void delete(int id) {
		getRemote().delete(id);
		
	}
	
	public static List<Service> findService(){
		return getRemote().findService();
	}
	public static List<Service> afficheAllService(){
		return getRemote().afficheAllService();
	}
	
	public static int NbreDeService(){
		return getRemote().NbreDeService();
	}
	public static void updateById(int id){
		getRemote().updateById(id);
	}
	
	public static List<Category> afficheCategory(){
		return getRemote().afficheCategory();
		
	}
	
	public static List<Service> serchByName(String name) {
		return getRemote().serchByName(name);
	}
	
	public static List<Service> searchByCategory(String category){
		return getRemote().searchByCategory(category);
	}
	public static void moveToOnotherCategory(int id , String nameCategory){
		getRemote().MoveToOtherCategory(id, nameCategory);
	}
	
	public static int nbVote(int id){
		return getRemote().nbVote(id);
	}
	public static float  MoyenneNote(int id){
		return getRemote().getnote(id);
	}
	public String getnbservice() {
		return getRemote().getnbservice();
	}

}
