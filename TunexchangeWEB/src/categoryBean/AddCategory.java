package categoryBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.esprit.pidev.crud.ManageCategoryLocal;
import com.esprit.pidev.jpa.Category;

@ViewScoped
@ManagedBean
public class AddCategory {

	private Category category = new Category();
	private Boolean form;
	
	@EJB
	ManageCategoryLocal local;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String addCategory(){
		local.addCategory(category);
		return null;
		
	}
	public boolean isForm() {
		return form;
	}
	public void setForm(boolean form) {
		this.form = form;
	}
}
