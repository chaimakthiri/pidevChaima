package com.esprit.gui;

import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.models.RechercheAdmin;
import com.esprit.models.TableAdmin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class SupprimerAdmin extends JPanel {
	int indice;
	private JTable table =new JTable();
	private JTextField tfRecherche;
	private JButton btnSupprimer;
	private JButton btnAdduser;
	
	JInternalFrame AddUser;
	JInternalFrame Mail;
	private JButton btnSendmail;
	private ManageAdministratorDelegate mad;
	
	/**
	 * Create the panel.
	 */
	public SupprimerAdmin() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mad=new ManageAdministratorDelegate();
		setForeground(SystemColor.control);
		
		
		setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Find By Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		tfRecherche = new JTextField();
		tfRecherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					table.setModel(new RechercheAdmin(tfRecherche.getText()
							.toString()));

					table.getColumnModel().getColumn(0).setHeaderValue("idUser");
					table.getColumnModel().getColumn(1).setHeaderValue("First Name");
					table.getColumnModel().getColumn(2).setHeaderValue("Last Name");
					table.getColumnModel().getColumn(3).setHeaderValue("Mail");
					table.getColumnModel().getColumn(4).setHeaderValue("Number");
					table.getColumnModel().getColumn(5).setHeaderValue("Login");
					table.getColumnModel().getColumn(6).setHeaderValue("Password");	
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tfRecherche.setColumns(10);
		
		
		btnSupprimer = new JButton("");
		btnSupprimer.setBackground(SystemColor.desktop);
		btnSupprimer.setIcon(new ImageIcon(SupprimerAdmin.class.getResource("/com/esprit/picture/button (6).png")));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				indice = Integer.parseInt(table.getValueAt(row, 0).toString());
				if(indice==0){
					btnSupprimer.setEnabled(false);
				}else{

					btnSupprimer.setEnabled(true);
				}
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
			int i=	JOptionPane.showConfirmDialog(null, "Do you want to delete this Administrator");
			if(i==0){
				mad.DeleteAdminnistrator(indice);
				table.setModel(new TableAdmin());

				table.getColumnModel().getColumn(0).setHeaderValue("idUser");
				table.getColumnModel().getColumn(1).setHeaderValue("First Name");
				table.getColumnModel().getColumn(2).setHeaderValue("Last Name");
				table.getColumnModel().getColumn(3).setHeaderValue("Mail");
				table.getColumnModel().getColumn(4).setHeaderValue("Number");
				table.getColumnModel().getColumn(5).setHeaderValue("Login");
				table.getColumnModel().getColumn(6).setHeaderValue("Password");	
				
			}}
		});
		
		btnAdduser = new JButton("");
		btnAdduser.setBackground(new Color(240, 240, 240));
		btnAdduser.setForeground(Color.BLACK);
		btnAdduser.setIcon(new ImageIcon(SupprimerAdmin.class.getResource("/com/esprit/picture/button (11).png")));
		 
		btnAdduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser = new AjoutAdminstrator() ;
				AddUser.setVisible(true);
				AddUser.setBounds(300, 10, 450, 470);
				SupprimerAdmin.this.add(AddUser);
				setComponentZOrder(AddUser, 0);
				
				
				
				
				
				
			}
		});
		
		btnSendmail = new JButton("");
		btnSendmail.setBackground(SystemColor.desktop);
		btnSendmail.setIcon(new ImageIcon(SupprimerAdmin.class.getResource("/com/esprit/picture/button (4).png")));
		btnSendmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mail= new EnvoyerMail();
				Mail.setVisible(true);
				Mail.setBounds(300, 10, 450, 370);
				SupprimerAdmin.this.add(Mail);
				setComponentZOrder(Mail, 0);
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(127)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(221)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfRecherche, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdduser, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(446)))
					.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
					.addComponent(btnSendmail, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(436)
					.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(465, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSendmail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdduser, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfRecherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
		);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				indice = Integer.parseInt(table.getValueAt(row, 0).toString());
			}
		});
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setModel(new TableAdmin());
		table.getColumnModel().getColumn(0).setHeaderValue("idUser");
		table.getColumnModel().getColumn(1).setHeaderValue("First Name");
		table.getColumnModel().getColumn(2).setHeaderValue("Last Name");
		table.getColumnModel().getColumn(3).setHeaderValue("Mail");
		table.getColumnModel().getColumn(4).setHeaderValue("Number");
		table.getColumnModel().getColumn(5).setHeaderValue("Login");
		table.getColumnModel().getColumn(6).setHeaderValue("Password");	
		
		
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		

	}
}
