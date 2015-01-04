package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

@Local
@Path("/service")
public interface ManageServiceLocal {
	@GET
	@Path("/rech/{n}/{no1}/{no2}/{p1}/{p2}/{c}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Service> findService(@PathParam("n")String name,@PathParam("no1")String note1,@PathParam("no2")String note2,@PathParam("p1")String price1,@PathParam("p2")String price2,@PathParam("c")String cat);
	
	
	@GET
	@Path("/showService/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Service ShowService(@PathParam("id")int id);
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
	public List<Service> afficheAlldesactiveService();
	public List<Service> afficheAllactiveService();
}
