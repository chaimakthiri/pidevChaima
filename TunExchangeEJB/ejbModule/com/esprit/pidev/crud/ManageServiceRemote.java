package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;


@Remote
public interface ManageServiceRemote {
	public void addService(Service s);
	public Service findById(int id);
	public void update(Service s);
	public void delete(int id);
	public List<Service> findService();
	
	public int NbreDeService();
	public void updateById(int id);
	public List<Service> afficheAllService();
	public List<Service> afficheCompanyService();
	public List<Service> afficheCustomerService();
	public List<Category> afficheCategory();
	public List<Service> serchByName(String name );
	public List<Service> searchByCategory(String category);
	public void MoveToOtherCategory(int id,String namCategory);
	public int nbVote(int id);
	public float getnote(int id);
	
	public String getnbservice();
	

}
