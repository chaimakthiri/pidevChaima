package com.esprit.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.esprit.delegate.ManageClaimsDelegate;
import com.esprit.delegate.ManageServiceDelegate;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	String nbservice;
	String nbcompany;
	String nbcontact;
	JPanel menu;
	public Home(final int idadmin) {
		setName("home");
		nbservice=new ManageServiceDelegate().getnbservice();
		if(Integer.parseInt(nbservice)>10){
			nbservice="+10";
		}
		nbcontact=new ManageClaimsDelegate().getnbClaims();
		if(Integer.parseInt(nbcontact)>10){
			nbcontact="+10";
		}
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel nservice = new JLabel("");
		nservice.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/"+nbservice+".png")));
		nservice.setBounds(262, 93, 76, 76);
		add(nservice);
		
		JLabel ncontact = new JLabel("");
		ncontact.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/"+nbcontact+".png")));
		ncontact.setBounds(601, 390, 76, 76);
		add(ncontact);
		
		JLabel user = new JLabel("");
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,1));
			}
		});
		user.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/Customer.png")));
		user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user.setBounds(388, 113, 256, 256);
		add(user);
		
		JLabel Service = new JLabel("");
		Service.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,0));
			}
		});
		Service.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Service.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/service.png")));
		Service.setBounds(46, 113, 256, 256);
		add(Service);
		
		
		JLabel Company = new JLabel("");
		Company.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,2));
			}
		});
		Company.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Company.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/company.png")));
		Company.setBounds(726, 113, 256, 256);
		add(Company);
		
		JLabel Stat = new JLabel("");
		Stat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,4));
				
			}
		});
		Stat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Stat.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/stat.png")));
		Stat.setBounds(46, 400, 256, 273);
		add(Stat);
		
		JLabel Claims = new JLabel("");
		Claims.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				 ((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,3));
			}
		});
	
		Claims.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Claims.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/icon_256.png")));
		Claims.setBounds(388, 417, 256, 249);
		add(Claims);
		
		JLabel administrator = new JLabel("");
		administrator.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				 ((Authentification) getParent().getParent().getParent()).permute(new Menu(idadmin,5));
			}
		});
		administrator.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		administrator.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/admin.png")));
		administrator.setBounds(726, 417, 256, 256);
		
		
		JLabel title = new JLabel("");
		title.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/title.png")));
		title.setBounds(201, 11, 688, 84);
		add(title);
		
		JLabel logout = new JLabel("");
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				((Authentification) getParent().getParent().getParent()).init();
			}
		});
		logout.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/logoutmenu.png")));
		logout.setBounds(726, 417, 256, 256);
		if(idadmin!=0){
			administrator.setVisible(false);

			add(logout);
		}else{
			logout.setVisible(false);
			add(administrator);
		}

		JLabel Menubackground = new JLabel("");
		Menubackground.setBounds(0, 0, 1229, 768);
		Menubackground.setIcon(new ImageIcon(Home.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		add(Menubackground);

	}
}
