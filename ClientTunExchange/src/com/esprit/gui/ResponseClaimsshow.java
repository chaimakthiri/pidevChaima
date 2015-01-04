package com.esprit.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.esprit.delegate.ManageResponseClaimsDelegate;
import com.esprit.pidev.jpa.Claims;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class ResponseClaimsshow extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	
	private com.esprit.pidev.jpa.ResponseClaims rc;
	private ManageResponseClaimsDelegate mrc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private ResponseClaimsshow frame;

			public void run() {
				try {
					frame = null;
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
	public ResponseClaimsshow(Claims cl) {
		mrc=new ManageResponseClaimsDelegate();
		rc=mrc.getResponseClaimsbyclaims(cl);
		setVisible(true);
		setBounds(100, 100, 435, 314);
		
		final JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(20, 84, 389, 105);
		textPane.setText(rc.getContent());
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setBounds(134, 228, 94, 39);
		button_1.setIcon(new ImageIcon(ResponseClaimsshow.class.getResource("/com/esprit/picture/closeframe.png")));
		getContentPane().setLayout(null);
		getContentPane().add(textPane);
		getContentPane().add(button_1);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblText.setForeground(new Color(192, 192, 192));
		lblText.setBounds(10, 59, 46, 14);
		getContentPane().add(lblText);
		
		JLabel lblAdministrator = new JLabel("Administrator:");
		lblAdministrator.setForeground(Color.LIGHT_GRAY);
		lblAdministrator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAdministrator.setBounds(10, 22, 122, 26);
		getContentPane().add(lblAdministrator);
		
		JLabel nameadmin = new JLabel("");
		nameadmin.setForeground(SystemColor.inactiveCaptionBorder);
		nameadmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		nameadmin.setBounds(140, 22, 122, 26);
		getContentPane().add(nameadmin);
		nameadmin.setText(rc.getAdmin().getFirstName());
		JLabel backgound = new JLabel("");
		backgound.setForeground(new Color(192, 192, 192));
		backgound.setIcon(new ImageIcon(ResponseClaimsshow.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		backgound.setBounds(0, 0, 432, 284);
		getContentPane().add(backgound);

	}
}
