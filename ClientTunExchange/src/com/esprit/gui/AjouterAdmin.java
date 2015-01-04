package com.esprit.gui;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.pidev.jpa.Administrator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class AjouterAdmin extends JPanel {
	private JTextField tfFirstName;
	private JTextField tfLastNam;
	private JTextField tfMail;
	private JTextField tfPhone;
	private JTextField tfLogin;
	private JTextField tfPassword;

	/**
	 * Create the panel.
	 */
	public AjouterAdmin() {
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.LIGHT_GRAY);
		lblFirstName.setBounds(53, 148, 83, 17);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(193, 148, 239, 20);
		tfFirstName.setBackground(Color.WHITE);
		tfFirstName.setForeground(Color.BLACK);
		tfFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setBounds(53, 179, 90, 17);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfLastNam = new JTextField();
		tfLastNam.setBounds(193, 179, 239, 20);
		tfLastNam.setForeground(Color.BLACK);
		tfLastNam.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(Color.LIGHT_GRAY);
		lblEmail.setBounds(53, 217, 55, 17);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfMail = new JTextField();
		tfMail.setBounds(193, 217, 239, 20);
		tfMail.setForeground(Color.BLACK);
		tfMail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.LIGHT_GRAY);
		lblPhone.setBounds(53, 255, 53, 17);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfPhone = new JTextField();
		tfPhone.setBounds(193, 255, 239, 20);
		tfPhone.setForeground(Color.BLACK);
		tfPhone.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setBounds(53, 303, 49, 17);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfLogin = new JTextField();
		tfLogin.setBounds(193, 303, 239, 20);
		tfLogin.setForeground(Color.BLACK);
		tfLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(53, 341, 80, 17);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		tfPassword = new JTextField();
		tfPassword.setBounds(193, 341, 237, 20);
		tfPassword.setForeground(Color.BLACK);
		tfPassword.setColumns(10);
		
		JButton btnValider = new JButton("");
		btnValider.setBounds(318, 379, 114, 40);
		btnValider.setIcon(new ImageIcon(AjouterAdmin.class.getResource("/com/esprit/picture/button (2).png")));
		btnValider.setForeground(Color.BLUE);
		btnValider.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnValider.setBackground(Color.LIGHT_GRAY);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfFirstName.getText().equals("")||tfMail.getText().equals("")||tfLastNam.getText().equals("")||tfPassword.getText().equals("")||tfPhone.getText().equals("")||tfLogin.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Erreur de saisie");
					tfFirstName.getText().equals("");
					tfLastNam.getText().equals("");
					tfMail.getText().equals("");
					tfPassword.getText().equals("");
					tfLogin.getText().equals("");
					tfPhone.getText().equals("");
					}
				else{
				//ManageAdministratorRemote proxy =ManageAdministratorDelegate.getrRemote();
				//InitialContext ctx = new InitialContext();
				//ManageAdministratorRemote proxy = (ManageAdministratorRemote) ctx
						//.lookup("/TunExchange/ManageAdministrator!com.esprit.pidev.crud.ManageAdministratorRemote");
				Administrator admin = new Administrator();
				admin.setFirstName(tfFirstName.getText());
				admin.setLastName(tfLastNam.getText());
				admin.setMail(tfMail.getText());
				admin.setPhone(tfPhone.getText());
				admin.setLogin(tfLogin.getText());
				admin.setPassword(ManageAdministratorDelegate.getEncodedPassword(tfPassword.getText()));
				int i=	JOptionPane.showConfirmDialog(null, "Do you want to add  Administrator ??");
				if(i==0){
				ManageAdministratorDelegate.addAdmin(admin);
				JOptionPane.showMessageDialog(null, "the Administrator '"
						+ tfFirstName.getText() + " " + tfLastNam.getText()
						+ "' was added successfully");
				System.out.println("Ajout avec succés");
				}}
			}
		});

		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 422, 119);
		label.setIcon(new ImageIcon(AjouterAdmin.class.getResource("/com/esprit/picture/imagesAdmin.jpg")));
		
		JButton buttonsupprimer = new JButton("");
		buttonsupprimer.setBounds(69, 379, 96, 40);
		buttonsupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JInternalFrame)getParent().getParent().getParent()).setVisible(false);
				
			}
		});
		buttonsupprimer.setIcon(new ImageIcon(AjouterAdmin.class.getResource("/com/esprit/picture/button (5).png")));
		setLayout(null);
		add(label);
		add(buttonsupprimer);
		add(btnValider);
		add(lblFirstName);
		add(lblLastName);
		add(lblEmail);
		add(lblPhone);
		add(lblLogin);
		add(lblPassword);
		add(tfPassword);
		add(tfPhone);
		add(tfMail);
		add(tfLastNam);
		add(tfFirstName);
		add(tfLogin);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1229, 768);
		background.setIcon(new ImageIcon(AjouterAdmin.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		background.setForeground(Color.LIGHT_GRAY);
		add(background);

	}
}
