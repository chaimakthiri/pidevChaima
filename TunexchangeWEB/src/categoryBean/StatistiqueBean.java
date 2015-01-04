package categoryBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import com.esprit.pidev.crud.ManageCategoryLocal;
import com.esprit.pidev.jpa.Category;

@ManagedBean
public class StatistiqueBean implements Serializable {

	// on recupere la list de category
	private List<Category> categories;
	// ensuite le proxy pour remplire la list
	@EJB
	private ManageCategoryLocal manageCategoryLocal;

	private PieChartModel pieModel1;

	@PostConstruct
	public void init() {
		categories = manageCategoryLocal.findCategories();
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModels() {
		createPieModel1();

	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		for (Category c : categories) {
			pieModel1.set(c.getNameCategory(), manageCategoryLocal
					.findAllServicesBtCategoryId(c.getIdCategory()).size());

		}

		pieModel1.setTitle("Category Pie");
		pieModel1.setLegendPosition("w");
	}

	public List<Category> getCategories() {
		categories = manageCategoryLocal.findCategories();
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
