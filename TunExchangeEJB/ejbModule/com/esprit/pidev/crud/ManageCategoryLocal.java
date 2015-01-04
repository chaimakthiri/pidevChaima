package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

@Local
@Path("/cat")
public interface ManageCategoryLocal {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Category> afficheCategory();

	public boolean addCategory(Category Category);

	public Category findById(int id);

	public boolean updateCat(Category Category);

	public boolean deleteCat(Category Category);

	public List<Category> findCategories();

	public List<Service> findAllServicesBtCategoryId(int idCategory);

	public List<Service> findAllServicesByCategoryName(String nameOfCategory);

	}
