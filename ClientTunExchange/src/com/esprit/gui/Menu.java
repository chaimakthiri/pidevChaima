package com.esprit.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;


import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menu(final int idadmin,int x) {
		setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tabbedPane.setBounds(0, 106, 1006, 552);
		add(tabbedPane);
		
		JPanel pservice = new ManageServicePanel();
		pservice.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/serviceicon.png")), pservice, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		JPanel pcustomer = new ListCustomers();
		tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/customericon.png")), pcustomer, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		
		JPanel pcompany = new CampanyPanel();
		pcompany.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/companyicon.png")), pcompany, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		
		

		JPanel pclaims = new ManageClaimsgui(idadmin);
		pclaims.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/claimsiconi.png")), pclaims, "");

		tabbedPane.setForegroundAt(3, Color.BLACK);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
	//	tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pservice, pcustomer, pcompany, padmin, pclaims}));
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon(Menu.class.getResource("/com/esprit/picture/title copy.png")));
		title.setBounds(152, 0, 620, 106);
		add(title);
		
		JPanel stat = new PieCharte();
		stat.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/staticon.png")), stat, null);
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		JLabel home = new JLabel("");
		if(idadmin==0){

			JPanel padmin = new SupprimerAdmin();
			tabbedPane.addTab("", new ImageIcon(Menu.class.getResource("/com/esprit/picture/adminicon.png")), padmin, null);
			tabbedPane.setBackgroundAt(5, Color.WHITE);
				}

		tabbedPane.setSelectedIndex(x);
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((Authentification) getParent().getParent().getParent()).permute(new Home(idadmin));
			}
		});
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setIcon(new ImageIcon(Menu.class.getResource("/com/esprit/picture/homei.png")));
		home.setBounds(76, 11, 80, 83);
		add(home);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((Authentification) getParent().getParent().getParent()).init();
			}
		});
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setIcon(new ImageIcon(Menu.class.getResource("/com/esprit/picture/logouti.png")));
		logout.setBounds(861, 14, 80, 80);
		add(logout);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1279, 768);
		background.setIcon(new ImageIcon(Menu.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		add(background);
		setVisible(true);
	}
	
}
