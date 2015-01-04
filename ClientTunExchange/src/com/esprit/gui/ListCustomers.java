package com.esprit.gui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import com.esprit.delegate.ManageUserDelegate;
import com.esprit.pidev.jpa.Customer;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.SystemColor;

import javax.swing.JLabel;



@SuppressWarnings("serial")
public class ListCustomers extends JPanel {
	private JTable table_Customer;
    static List<Customer> listcustomer;
    private JTextField textFieldSearchCust;
    private JTextField textFieldTokenCust;
	/**
	 * Create the panel.
	 */
	public ListCustomers() {
		setBackground(SystemColor.inactiveCaption);
		listcustomer=ManageUserDelegate.afficheCustomers();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(null, "Customers List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(null, "Update Tokens", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(245, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		
		textFieldTokenCust = new JTextField();
		textFieldTokenCust.setColumns(10);
		
		JButton btnUpdateCust = new JButton("");
		btnUpdateCust.setIcon(new ImageIcon(ListCustomers.class.getResource("/com/esprit/picture/button (12).png")));
		btnUpdateCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_Customer.getSelectedRow();
				int click = (int) table_Customer.getModel().getValueAt(row, 0);
				Customer c = ManageUserDelegate.findById(click);
			
				c.setSoldeToken(Integer.valueOf(textFieldTokenCust.getText()));

				

				ManageUserDelegate.updateCustomer(c);

				listcustomer = ManageUserDelegate.afficheCustomers();
				textFieldTokenCust.setText("");
				//textFieldSearchCust.setText("");
				

				initDataBindings();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ListCustomers.class.getResource("/com/esprit/picture/CygnarTokens.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(textFieldTokenCust, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdateCust, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 269, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnUpdateCust, 0, 0, Short.MAX_VALUE)
						.addComponent(textFieldTokenCust, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(7))
		);
		panel_2.setLayout(gl_panel_2);
		
		textFieldSearchCust = new JTextField();
		textFieldSearchCust.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
             listcustomer=ManageUserDelegate.afficheCustomers();
				
				initDataBindings();
			}
		
		});
		textFieldSearchCust.setColumns(10);
		
		JButton btnSearchCust = new JButton("");
		btnSearchCust.setIcon(new ImageIcon(ListCustomers.class.getResource("/com/esprit/picture/button (14).png")));
		btnSearchCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listcustomer=ManageUserDelegate.searchCustomers(textFieldSearchCust.getText());
				initDataBindings();
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ListCustomers.class.getResource("/com/esprit/picture/t\u00E9l\u00E9chargement.jpg")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addComponent(textFieldSearchCust, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearchCust, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldSearchCust)
						.addComponent(btnSearchCust, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnDeleteCust = new JButton("");
		btnDeleteCust.setIcon(new ImageIcon(ListCustomers.class.getResource("/com/esprit/picture/button (13).png")));
		btnDeleteCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					Context ctx = new InitialContext();
//					ManageUserRemote userRemote = (ManageUserRemote) ctx
//							.lookup("/TunExchange/ManageUser!com.esprit.pidev.crud.ManageUserRemote");
					Customer j = new Customer();
					j.setIdUser((int) table_Customer.getValueAt(table_Customer.getSelectedRow(), 0));//recuperer l'id de l'objet selectionée du tab
					
				ManageUserDelegate.deleteCustomer(j);
				listcustomer.remove(table_Customer.getSelectedRow());  // suppresion de la liste
				table_Customer.repaint(); // refraichement
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
		}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(542, Short.MAX_VALUE)
							.addComponent(btnDeleteCust, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDeleteCust, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table_Customer = new JTable();
		table_Customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table_Customer.getSelectedRow();
				int id=(int)table_Customer.getModel().getValueAt(row,0);
				Customer c = ManageUserDelegate.findById(id);
				textFieldTokenCust.setText(String.valueOf(c.getSoldeToken()));
				initDataBindings();
			}
			
		});
		scrollPane.setViewportView(table_Customer);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Customer, List<Customer>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listcustomer, table_Customer);
		//
		BeanProperty<Customer, String> userBeanProperty = BeanProperty.create("idUser");
		jTableBinding.addColumnBinding(userBeanProperty).setColumnName("Id");
		//
		BeanProperty<Customer, String> userBeanProperty5 = BeanProperty.create("firstName");
		jTableBinding.addColumnBinding(userBeanProperty5).setColumnName("Name");
		//
    	BeanProperty<Customer, String> userBeanProperty1 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(userBeanProperty1).setColumnName("Last Name");
			BeanProperty<Customer, String> userBeanProperty2 = BeanProperty.create("phone");
			jTableBinding.addColumnBinding(userBeanProperty2).setColumnName("Phone Number");
			//
			BeanProperty<Customer, String> userBeanProperty3 = BeanProperty.create("adresse");
			jTableBinding.addColumnBinding(userBeanProperty3).setColumnName("Adress");
			//
			BeanProperty<Customer, String> userBeanProperty4 = BeanProperty.create("mail");
			jTableBinding.addColumnBinding(userBeanProperty4).setColumnName("Mail");
			//
			BeanProperty<Customer, Integer> userBeanProperty6 = BeanProperty.create("soldeToken");
			jTableBinding.addColumnBinding(userBeanProperty6).setColumnName("Solde Token");
			//
			
		jTableBinding.bind();
	}
}
