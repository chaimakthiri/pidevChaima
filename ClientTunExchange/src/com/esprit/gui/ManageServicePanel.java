package com.esprit.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTable;

import com.esprit.delegate.ManageServiceDelegate;
import com.esprit.pidev.jpa.Category;
import com.esprit.pidev.jpa.Service;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
 

@SuppressWarnings("serial")
public class ManageServicePanel extends JPanel {
	private JTextField NbToken_textField;
	private JTable table_waiting_srvice;
	List<Service> services;
	private JTextField Search_textField;
	private JTextField NbToken_textField_2;
	private JTable table_validate_service;
	List<Service> listService;
	final JTextArea Description_textArea = new JTextArea();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_moveCategory = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox_serch_bycategory = new JComboBox();
	List<Category> categories;
	JSlider slider = new JSlider();
	private JButton btn_update_validate_service;
	private JPanel panel_4;
	private JPanel panel;
	private JButton btnMove;
	private JButton btnClear;
	
	

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public ManageServicePanel() {
		setBackground(SystemColor.inactiveCaption);
		
		//*********************************
		
		
		
		
		
		//********* affiche dans combobox ************
				categories=ManageServiceDelegate.afficheCategory();
				
				for(Category c:categories){
					comboBox_serch_bycategory.addItem(c.getNameCategory());
					 comboBox_moveCategory.addItem(c.getNameCategory());
					 
					
				}
				
				  //******* affichage de Jtable *************
						services = ManageServiceDelegate.findService();
						listService=ManageServiceDelegate.afficheAllService();
						
			     ///*************************************************			

		
		
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
		);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Waiting services", null, panel, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add to the validated list or delete ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.menuText));
		
		JLabel label = new JLabel("Description");
		
		JLabel label_1 = new JLabel("Token");
		
		NbToken_textField = new JTextField();
		NbToken_textField.setColumns(10);
		
		
		
		JButton button_add_service = new JButton("");
		button_add_service.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/addService.png")));
		button_add_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 // ***************** Ajouter un service en attente *************
				int i1 =JOptionPane.showConfirmDialog(null, "do you want add this service");

				if(i1==0){
				int row = table_waiting_srvice.getSelectedRow();
				int click = (int) table_waiting_srvice.getModel().getValueAt(row, 0);
				Service c = ManageServiceDelegate.findById(click);
				
			    //c.setPrixToken(spinner.getComponentCount());
				c.setPrixToken(Integer.valueOf(NbToken_textField.getText()));
				

				int i = 1;
				boolean b = (i != 0);
				c.setEtat(b);

				ManageServiceDelegate.update(c);

				services = ManageServiceDelegate.findService();
				listService=ManageServiceDelegate.afficheAllService();
				NbToken_textField.setText("");
				Description_textArea.setText("");

				initDataBindings();}
				
				
				
			}
		});
		
		JButton button_delete_waiting_service = new JButton("");
		button_delete_waiting_service.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/Delete_waiting_Service.png")));
		button_delete_waiting_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				//********* supprission d'un service *******************
				 
				int i1 =JOptionPane.showConfirmDialog(null, "do you want delete this service");

				if(i1==0){
					
					

					int row = table_waiting_srvice.getSelectedRow();
					int click = (int) table_waiting_srvice.getModel().getValueAt(row, 0);

					ManageServiceDelegate.delete(Integer.valueOf(click));
					services = ManageServiceDelegate.findService();
					NbToken_textField.setText("");
					Description_textArea.setText("");
					initDataBindings();}
				
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(NbToken_textField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(Description_textArea, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_add_service, 0, 0, Short.MAX_VALUE)
						.addComponent(button_delete_waiting_service, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE))
					.addGap(57))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(NbToken_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(26)
									.addComponent(label))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(Description_textArea, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(15)
							.addComponent(button_add_service, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_delete_waiting_service, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Move to another category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		
		btnMove = new JButton("");
		btnMove.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/Move.png")));
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				/// ****** Move to another categorie ***** ///////
				int i1 =JOptionPane.showConfirmDialog(null, "do you want move this service to another category ");

				if(i1==0){
			
					
					
					
				int row = table_waiting_srvice.getSelectedRow();
				int click = (int) table_waiting_srvice.getModel().getValueAt(row, 0);
				String nameCategory=(String) comboBox_moveCategory.getSelectedItem();
				ManageServiceDelegate.moveToOnotherCategory(click, nameCategory);
				services=ManageServiceDelegate.findService();
				
			   initDataBindings();
			}}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addGap(20)
					.addComponent(comboBox_moveCategory, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(btnMove, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(12)
					.addComponent(comboBox_moveCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnMove, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(UIManager
								.getBorder("TitledBorder.border"),
								"Liste de services en attente", TitledBorder.CENTER,
								TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 791, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 206, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table_waiting_srvice = new JTable();
		table_waiting_srvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table_waiting_srvice.getSelectedRow();
				int click = (int) table_waiting_srvice.getModel().getValueAt(row, 0);
				Service c = ManageServiceDelegate.findById(click);
			
				NbToken_textField.setText(String.valueOf(c.getPrixToken()));
				Description_textArea.setText(c.getDescription());
				
				initDataBindings();
			}
		});
		scrollPane.setViewportView(table_waiting_srvice);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 791, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("validate Services", null, panel_1, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new TitledBorder(null, "Liste de services valid\u00E9", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 604, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 233, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_validate_service = new JTable();
		table_validate_service.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			//// ***** selectonner les chaps dans la liste des service validé ******
				
				

					int row = table_validate_service.getSelectedRow();
					int click = (int) table_validate_service.getModel().getValueAt(row, 0);
					Service c = ManageServiceDelegate.findById(click);
					NbToken_textField_2.setText(String.valueOf(c.getPrixToken()));
					
					
					initDataBindings();
				
				
			}
		});
		scrollPane_1.setViewportView(table_validate_service);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBorder(new TitledBorder(null, "Search by service category", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox_serch_bycategory, 0, 134, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox_serch_bycategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		comboBox_serch_bycategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// ********** Search by category **************
				
				String category=comboBox_serch_bycategory.getSelectedItem().toString();
							
			  listService=ManageServiceDelegate.searchByCategory(category);
				initDataBindings();
			}
		});
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setForeground(Color.BLACK);
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search by service name", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		Search_textField = new JTextField();
		Search_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				// *********** Search By name 
				
					
					listService=ManageServiceDelegate.serchByName(Search_textField.getText());
					initDataBindings();
				
				
			}
		});
		Search_textField.setColumns(10);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(Search_textField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(Search_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		
		JSeparator separator = new JSeparator();
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBorder(new TitledBorder(null, "Update or Delete Service and goods", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_2 = new JLabel("Prix Tokens");
		
		NbToken_textField_2 = new JTextField();
		NbToken_textField_2.setColumns(10);
		
		JButton btn_delete_validate_service = new JButton("");
		btn_delete_validate_service.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/DeleteValidateService.png")));
		btn_delete_validate_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                  ///****** delete service validé *************
				
				int i1 =JOptionPane.showConfirmDialog(null, "do you want delete this service");

				if(i1==0){
				

				int row = table_validate_service.getSelectedRow();
				int click = (int) table_validate_service.getModel().getValueAt(row, 0);

				ManageServiceDelegate.delete(Integer.valueOf(click));
				listService = ManageServiceDelegate.afficheAllService();
				NbToken_textField_2.setText("");
				Search_textField.setText("");
				initDataBindings();}
			
			}
		});
		
		btn_update_validate_service = new JButton("");
		btn_update_validate_service.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/updateService.png")));
		btn_update_validate_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///****** Update nombre de token *******
				int i1 =JOptionPane.showConfirmDialog(null, "do you want add this service");

				if(i1==0){
				
					
					int row = table_validate_service.getSelectedRow();
					int click = (int) table_validate_service.getModel().getValueAt(row, 0);
					Service c = ManageServiceDelegate.findById(click);
				
					c.setPrixToken(Integer.valueOf(NbToken_textField_2.getText()));

					
                 
					ManageServiceDelegate.update(c);

					listService = ManageServiceDelegate.afficheAllService();
					NbToken_textField_2.setText("");
					Search_textField.setText("");
					

					initDataBindings();}
				
				
			}
		});
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(NbToken_textField_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btn_update_validate_service, 0, 0, Short.MAX_VALUE)
						.addComponent(btn_delete_validate_service, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE))
					.addGap(92))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(NbToken_textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_update_validate_service, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btn_delete_validate_service, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBorder(new TitledBorder(null, "Evaluate service and goods", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		slider.setValue(1);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		
		JButton btn_rate = new JButton("");
		btn_rate.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/RateService.png")));
		btn_rate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				//****** rate service *****
				
				int i1 =JOptionPane.showConfirmDialog(null, "do you want add this service");

				if(i1==0){
				int row = table_validate_service.getSelectedRow();
				int click = (int) table_validate_service.getModel().getValueAt(row, 0);
				Service c = ManageServiceDelegate.findById(click);
				

				float note=(float)slider.getValue()+ManageServiceDelegate.MoyenneNote(click);
				int nbvote=ManageServiceDelegate.nbVote(click)+1;
				float a=note/nbvote;
				c.setNbVote(nbvote);
				c.setNote(note);
				c.setMoyenne(a);
				
			
			
				
			ManageServiceDelegate.update(c);
			listService=ManageServiceDelegate.afficheAllService();
			
			initDataBindings();
//				
		//	System.out.println(slider.getValue());
			
				
				
				
			}}
		});
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(109)
							.addComponent(btn_rate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_10.createSequentialGroup()
							.addContainerGap()
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btn_rate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		panel_10.setLayout(gl_panel_10);
		
		btnClear = new JButton("");
		btnClear.setIcon(new ImageIcon(ManageServicePanel.class.getResource("/com/esprit/picture/buttonClear.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// ******** Bouton Clear pour la liste des services validé ********************
				
					listService=ManageServiceDelegate.afficheAllService();
					NbToken_textField_2.setText("");
					Search_textField.setText("");
					initDataBindings();
				
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
							.addGap(52))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(63)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(50)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
							.addGap(22)
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(35)))
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(97))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(263, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
					.addGap(44))
		);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 842, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);
		initDataBindings();

	}
	
	protected void initDataBindings() {
		JTableBinding<Service, List<Service>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, services, table_waiting_srvice);
		BeanProperty<Service, Integer> serviceBeanProperty = BeanProperty.create("idService");
		jTableBinding.addColumnBinding(serviceBeanProperty).setColumnName("id ");
		//
		BeanProperty<Service, String> serviceBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(serviceBeanProperty_1).setColumnName("name of service ");
		//
		BeanProperty<Service, String> serviceBeanProperty_2 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(serviceBeanProperty_2).setColumnName("description");
		//
		BeanProperty<Service, String> serviceBeanProperty_3 = BeanProperty.create("user.firstName");
		jTableBinding.addColumnBinding(serviceBeanProperty_3).setColumnName(" name User ");
		//
		BeanProperty<Service, String> serviceBeanProperty_4 = BeanProperty.create("prixToken");
		jTableBinding.addColumnBinding(serviceBeanProperty_4).setColumnName("Token ");
		//
		BeanProperty<Service, String> serviceBeanProperty_5 = BeanProperty.create("user.mail");
		jTableBinding.addColumnBinding(serviceBeanProperty_5).setColumnName("mail of user ");
		//
		BeanProperty<Service, String> serviceBeanProperty_6 = BeanProperty.create("user.phone");
		jTableBinding.addColumnBinding(serviceBeanProperty_6).setColumnName("phone of user ");
		BeanProperty<Service, String> serviceBeanProperty_16 = BeanProperty.create("category.nameCategory");
		jTableBinding.addColumnBinding(serviceBeanProperty_16).setColumnName("Categorie service ");
		BeanProperty<Service, String> serviceBeanProperty_20 = BeanProperty.create("note");
		jTableBinding.addColumnBinding(serviceBeanProperty_20).setColumnName("note service ");
		//
	
		jTableBinding.bind();
		
		
		JTableBinding<Service, List<Service>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, listService, table_validate_service);
		
		BeanProperty<Service, Integer> serviceBeanProperty_8 = BeanProperty.create("idService");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_8).setColumnName("id ");
		//
		BeanProperty<Service, String> serviceBeanProperty_9 = BeanProperty.create("name");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_9).setColumnName("name of service ");
		//
		BeanProperty<Service, String> serviceBeanProperty_10 = BeanProperty.create("description");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_10).setColumnName("description");
		//
		BeanProperty<Service, String> serviceBeanProperty_11 = BeanProperty.create("user.firstName");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_11).setColumnName(" name User ");
		//
		BeanProperty<Service, String> serviceBeanProperty_12 = BeanProperty.create("prixToken");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_12).setColumnName("Token ");
		//
		BeanProperty<Service, String> serviceBeanProperty_13 = BeanProperty.create("user.mail");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_13).setColumnName("mail of user ");
		//
		BeanProperty<Service, String> serviceBeanProperty_14 = BeanProperty.create("user.phone");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_14).setColumnName("phone of user ");
		BeanProperty<Service, String> serviceBeanProperty_17 = BeanProperty.create("category.nameCategory");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_17).setColumnName("Categorie service ");
		
		BeanProperty<Service, String> serviceBeanProperty_21 = BeanProperty.create("moyenne");
		jTableBinding_1.addColumnBinding(serviceBeanProperty_21).setColumnName("note service ");
		//
		
		
		
		
		jTableBinding_1.bind();
		}
}

