package com.esprit.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.pidev.jpa.Administrator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import java.awt.Font;

public class Authentification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setName("frame");
		setTitle("Tunexchange");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Authentification.class.getResource("/com/esprit/picture/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 735);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);

		login = new JTextField();
		login.setBounds(496, 399, 134, 28);
		login.setFont(new Font("Tahoma", Font.PLAIN, 16));
		login.setHorizontalAlignment(SwingConstants.LEFT);
		login.setColumns(10);

		final JLabel labLogin = new JLabel("Login");
		labLogin.setBounds(411, 399, 59, 28);
		labLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		final JLabel labPassword = new JLabel("Password");
		labPassword.setBounds(411, 445, 92, 28);
		labPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));

		final JLabel er1 = new JLabel("");
		er1.setBounds(425, 370, 279, 18);
		er1.setForeground(Color.RED);
//authentification
		JButton btnConnect = new JButton("");
		btnConnect.setBounds(520, 495, 134, 38);
		btnConnect.setBackground(new Color(204, 255, 255));
		btnConnect.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/button.png")));
		btnConnect.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Administrator ad = ManageAdministratorDelegate.authentificate(
						login.getText(), password.getText());
				if (ad.getIdAdmin() == -1) {
					er1.setText("login or passwor"
							+ "d is incorrect");
				} else {
					permute(new Home(ad.getIdAdmin()));
				}
			}
		});
		
		JLabel lblKk = new JLabel("");
		lblKk.setBounds(411, 11, 208, 208);
		lblKk.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/logo.png")));
		
		JLabel iconuser = new JLabel("");
		iconuser.setBounds(604, 399, 26, 28);
		iconuser.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/Icon-us.png")));
		
		JLabel pass = new JLabel("");
		pass.setBounds(604, 445, 26, 28);
		pass.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/pass.png")));
		
		password = new JPasswordField();
		password.setBounds(496, 445, 134, 28);
		password.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(359, 323, 310, 235);
		label_1.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/log.png")));
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1365, 768);
		label.setIcon(new ImageIcon(Authentification.class.getResource("/com/esprit/picture/Background.jpg")));
		contentPane.setLayout(null);
		contentPane.add(lblKk);
		contentPane.add(er1);
		contentPane.add(iconuser);
		contentPane.add(pass);
		contentPane.add(login);
		contentPane.add(btnConnect);
		contentPane.add(labPassword);
		contentPane.add(labLogin);
		contentPane.add(password);
		contentPane.add(label_1);
		contentPane.add(label);
	//	setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{login, password, btnConnect}));
	}
	public void permute(JPanel pan){
		contentPane.setVisible(false);
		setContentPane(pan);
		revalidate();
	}
	public void init(){
		login.setText("");
		password.setText("");
		contentPane.setVisible(true);
		setContentPane(contentPane);
		revalidate();
	}
}
