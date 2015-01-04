package com.esprit.gui;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class SendMail extends JPanel {
	private JTextField txtrecepteur;
	private JTextField tfSubject;
	JTextArea textAreaSujet = new JTextArea();

	/**
	 * Create the panel.
	 */
	
	public void close(){
		this.removeAll();
	}
	public SendMail() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(128, 128, 128));
		setForeground(Color.WHITE);

		JLabel lblSendto = new JLabel("Send-To");
		lblSendto.setBounds(23, 47, 70, 17);
		lblSendto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		txtrecepteur = new JTextField();
		txtrecepteur.setBounds(97, 47, 120, 20);
		txtrecepteur.setColumns(10);

		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(23, 85, 61, 17);
		lblSubject.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		tfSubject = new JTextField();
		tfSubject.setBounds(97, 73, 120, 20);
		tfSubject.setColumns(10);

		JLabel lblText = new JLabel("Text");
		lblText.setBounds(23, 111, 45, 17);
		lblText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(235, 11, 178, 234);
		lblNewLabel.setIcon(new ImageIcon(SendMail.class
				.getResource("/com/esprit/picture/mail3.png")));

		JButton btnEnvoyer = new JButton("");
		btnEnvoyer.setBounds(207, 251, 146, 47);
		btnEnvoyer.setIcon(new ImageIcon(SendMail.class
				.getResource("/com/esprit/picture/button (4).png")));
		btnEnvoyer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "587");
				props.put("mail.smtp.socketFactory.class",
						"javax.net.SocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.ssl.enable", "false");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

				Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(
										"tunexchangeesprit@gmail.com",
										"25096748");
							}
						});

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(
							"tunexchangeesprit@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(txtrecepteur.getText()
									.toString()));
					message.setSubject(tfSubject.getText().toString());
					message.setText(textAreaSujet.getText().toString());
					if(textAreaSujet.getText().equals("")){
						JOptionPane.showMessageDialog(null,
								"Error");
					}
					else{ 

					Transport.send(message);
					JOptionPane.showMessageDialog(null,
							"Email was sent successfully");
					System.out.println("Done");
					}

				}

				catch (MessagingException x) {
					// throw new RuntimeException(e);
					System.out
							.println("Username or Password are incorrect ... exiting !");
				}

			}
		});
		btnEnvoyer.setBackground(Color.BLACK);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(97, 251, 104, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SendMail.this.setVisible(false);
				 //new test().setVisible(true);
				((JInternalFrame)getParent().getParent().getParent()).setVisible(false);
			

			}
		});
		btnNewButton.setIcon(new ImageIcon(SendMail.class
				.getResource("/com/esprit/picture/button (5).png")));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SendMail.class.getResource("/com/esprit/picture/Menubackground.jpg")));
		label.setBounds(2, 2, 1229, 768);
		label.setForeground(Color.LIGHT_GRAY);
		setLayout(null);
		add(lblSubject);
		add(lblSendto);
		add(lblText);
		add(btnNewButton);
		add(btnEnvoyer);
		add(txtrecepteur);
		add(tfSubject);
		textAreaSujet.setBounds(97, 111, 120, 110);
		add(textAreaSujet);
		add(lblNewLabel);
		add(label);

	}
}
