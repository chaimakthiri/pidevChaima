package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

@Remote
public interface ManageCategoryRemote {
	public boolean addCategory(Category Category);

	public Category findById(int id);

	public boolean updateCat(Category Category);

	public boolean deleteCat(Category Category);

	public List<Category> findCategories();

	public List<Category> afficheCategory();

	public List<Service> findAllServicesBtCategoryId(int idCategory);

	public List<Service> findAllServicesByCategoryName(String nameOfCategory);

}
