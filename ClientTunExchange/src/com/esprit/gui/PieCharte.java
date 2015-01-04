package com.esprit.gui;

import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.esprit.delegate.ManageCategoryDelegate;
import com.esprit.delegate.ManageServiceDelegate;
import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class PieCharte extends JPanel {
	DefaultPieDataset dataset;// // les données
	JFreeChart graphe; // le graphe
	ChartPanel cp; // le contenaire

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("static-access")
	public PieCharte() {
		// instancier le dataset
				dataset = new DefaultPieDataset();
				// remplissage du dataset
				List<Category> category = ManageCategoryDelegate.afficheCategory();
				List<Service> services =ManageServiceDelegate.afficheAllService();
				int nbservices = 0;
				for (Category c : category) {
					for (Service s : services) {
						
						if (s.getCategory().getIdCategory()==c.getIdCategory()) {
							
							nbservices++;
							dataset.setValue(c.getNameCategory(), nbservices);
						}
						
						
					}nbservices=0;
					
				}
				// Création du graphe
				graphe = ChartFactory.createPieChart(
						"Statics", dataset,
						true, true, false);
				// associer le graphe au Chart Panel
				cp = new ChartPanel(graphe);
				cp.DEFAULT_HEIGHT = 350;
				cp.DEFAULT_WIDTH = 350;
				GroupLayout gl_cp = new GroupLayout(cp);
				gl_cp.setHorizontalGroup(
					gl_cp.createParallelGroup(Alignment.LEADING)
						.addGap(0, 1000, Short.MAX_VALUE)
				);
				gl_cp.setVerticalGroup(
					gl_cp.createParallelGroup(Alignment.LEADING)
						.addGap(0, 570, Short.MAX_VALUE)
				);
				cp.setLayout(gl_cp);
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cp, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(cp, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(135, Short.MAX_VALUE))
				);
				setLayout(groupLayout);
			

	}

}
