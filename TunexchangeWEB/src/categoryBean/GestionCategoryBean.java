package categoryBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.esprit.pidev.crud.ManageCategoryLocal;
import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

@SessionScoped
@ManagedBean(name = "GestionCategoryBean")
public class GestionCategoryBean {

	@EJB
	ManageCategoryLocal local;
	private Category categorySelected = new Category();
	private int idOfCategorySelected;

	public GestionCategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<Service> services = new ArrayList<Service>();

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	private List<Category> categories = new ArrayList<Category>();
	private Category category = new Category();
	private boolean form;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategory(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public String newCategory() {
		form = true;
		category = new Category();
		return null;
	}

	@PostConstruct
	public void init() {
		categories = local.findCategories();
		services = local.findAllServicesBtCategoryId(idOfCategorySelected);
	}

	public void doFindServicesByCategoryName() {
		services = local.findAllServicesByCategoryName(categorySelected
				.getNameCategory());
	}

	public String validate() {
		local.updateCat(category);
		form = false;
		category = new Category();
		init();
		return null;
	}

	public String delete() {
		local.deleteCat(category);
		init();
		return null;
	}

	public Category getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(Category categorySelected) {
		this.categorySelected = categorySelected;
	}

	public int getIdOfCategorySelected() {
		return idOfCategorySelected;
	}

	public void setIdOfCategorySelected(int idOfCategorySelected) {
		this.idOfCategorySelected = idOfCategorySelected;
	}

}
