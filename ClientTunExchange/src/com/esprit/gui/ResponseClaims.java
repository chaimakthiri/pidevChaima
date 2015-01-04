package com.esprit.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.esprit.delegate.ManageAdministratorDelegate;
import com.esprit.delegate.ManageClaimsDelegate;
import com.esprit.delegate.ManageResponseClaimsDelegate;
import com.esprit.mail.Sendmail;
import com.esprit.pidev.jpa.Claims;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class ResponseClaims extends JInternalFrame {

	/**
	 * Launch the application.
	 */

	private com.esprit.pidev.jpa.ResponseClaims rc;
	
	private Claims c;
	private ManageResponseClaimsDelegate mrc;
	private ManageClaimsDelegate mdc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private ResponseClaims frame;

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
	public ResponseClaims(final int idAdmin,int idc) {
		mrc=new ManageResponseClaimsDelegate();
		mdc=new ManageClaimsDelegate();
		c=mdc.getClaimsbyid(idc);
		setVisible(true);
		setBounds(100, 100, 435, 314);
		rc=new com.esprit.pidev.jpa.ResponseClaims();
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 44, 388, 145);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new Sendmail().Sendmailresult(c.getEmail(),"RE:"+c.getSubject(),textPane.getText()))
				{
					if(textPane.getText().length()==0){
						JOptionPane.showMessageDialog(null,
								"Please write text");
					}else{
					rc.setAdmin(new ManageAdministratorDelegate().findById(idAdmin));
					rc.setContent(textPane.getText());
					c.setEtat(true);
					rc.setClaims(c);
					mrc.add(rc);
					mdc.update(c);
					JOptionPane.showMessageDialog(null,
							"Mail send successfully");
					setVisible(false);
				}}
				else{
					JOptionPane.showMessageDialog(null,
							"Please check your internet connection");
				}
			
			}
		});
		button.setBounds(273, 228, 149, 39);
		button.setIcon(new ImageIcon(ResponseClaims.class.getResource("/com/esprit/picture/sendemail.png")));
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setBounds(141, 228, 105, 39);
		button_1.setIcon(new ImageIcon(ResponseClaims.class.getResource("/com/esprit/picture/cancel.png")));
		getContentPane().setLayout(null);
		getContentPane().add(textPane);
		getContentPane().add(button_1);
		getContentPane().add(button);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblText.setForeground(new Color(192, 192, 192));
		lblText.setBounds(10, 19, 46, 14);
		getContentPane().add(lblText);
		
		JLabel backgound = new JLabel("");
		backgound.setForeground(new Color(192, 192, 192));
		backgound.setIcon(new ImageIcon(ResponseClaims.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		backgound.setBounds(0, 0, 432, 284);
		getContentPane().add(backgound);

	}
}
