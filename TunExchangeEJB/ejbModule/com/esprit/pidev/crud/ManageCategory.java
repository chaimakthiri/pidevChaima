package com.esprit.pidev.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

/**
 * Session Bean implementation class MangeCategory
 */
@Stateless
@LocalBean
public class ManageCategory implements ManageCategoryRemote,
		ManageCategoryLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */

	public ManageCategory() {

	}

	@Override
	public boolean addCategory(Category category) {
		em.persist(category);

		return true;

	}

	@Override
	public Category findById(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public boolean updateCat(Category category) {
		em.merge(category);

		return true;

	}

	@Override
	public boolean deleteCat(Category category) {
		em.remove(em.merge(category));
		return true;

	}

	@Override
	public List<Category> findCategories() {
		Query query = em.createQuery("select s from Category s");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> afficheCategory() {
		Query q = em.createQuery("Select c from Category c");
		List<Category> listeCategorie = q.getResultList();
		return listeCategorie;

	}

	@Override
	public List<Service> findAllServicesBtCategoryId(int idCategory) {
		String jpql = "select s from Service s where s.category.idCategory="
				+ idCategory;
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Service> findAllServicesByCategoryName(String nameOfCategory) {
		String jpql = "select s from Service s where s.category.nameCategory like '"
				+ nameOfCategory + "' ";
		Query query = em.createQuery(jpql);

		return query.getResultList();
	}

}
