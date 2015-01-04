package com.esprit.gui;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import com.esprit.delegate.ManageCampanyDelegate;
import com.esprit.delegate.ManageContractDelegate;
import com.esprit.pidev.jpa.Campany;
import com.esprit.pidev.jpa.Contract;

import javax.swing.JTable;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.swing.UIManager;

@SuppressWarnings("serial")
public class CampanyPanel extends JPanel {
	private JTextField idField;
	private JTextField amountField;
	private JTextField dateField_2;
	private JTextField dateField_1;
	private JTextField TokensField;
	private JTextField subjectField;
	List<Campany> campanies;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CampanyPanel() {
		
		campanies=ManageCampanyDelegate.afficheCampany();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.inactiveCaption);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Contract infos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		
		JLabel label = new JLabel("Contract id");
		
		JLabel label_1 = new JLabel("Amount");
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		
		JLabel label_2 = new JLabel("Creation date");
		
		JLabel label_3 = new JLabel("Expiration date");
		
		dateField_2 = new JTextField();
		dateField_2.setColumns(10);
		
		JButton btnUpdateContract = new JButton("");
		btnUpdateContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 0);	
				Campany c =ManageCampanyDelegate.findById((int)selectedObject);
				Contract cnt = c.getContrat();
				cnt.setPrix(Float.parseFloat(amountField.getText()));
				try {
					cnt.setDateExpiration(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateField_2.getText()));
				} catch (ParseException e) {
					System.out.println("wrong date");
					e.printStackTrace();
				}
				ManageContractDelegate.update(cnt);
			}
		});
		btnUpdateContract.setIcon(new ImageIcon(CampanyPanel.class.getResource("/com/esprit/picture/update_cnt.png")));
		
		dateField_1 = new JTextField();
		dateField_1.setEditable(false);
		dateField_1.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(amountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(88)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(dateField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(btnUpdateContract, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(dateField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(amountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(dateField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addComponent(btnUpdateContract, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Campanies List", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_2.setBackground(SystemColor.inactiveCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 734, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 6);	
				/*spli9*/
				TokensField.setText(selectedObject.toString());
				
				Object selectedObject2 = (Object) table.getModel().getValueAt(selectedRowIndex, 0);	
				Campany c =ManageCampanyDelegate.findById((int)selectedObject2);
				Contract cnt = c.getContrat();
				Object idCnt = cnt.getIdContract();
				/* spli9 */
				idField.setText(idCnt.toString());
				Object amCnt =cnt.getPrix();
				amountField.setText(amCnt.toString());
				Object dateCr = cnt.getDateCreat();
				Object dateEx = cnt.getDateExpiration();
				dateField_1.setText(dateCr.toString());
				dateField_2.setText(dateEx.toString());
			}
		});
		
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(CampanyPanel.class.getResource("/com/esprit/picture/campanies.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Tokens", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.inactiveCaption);
		
		JButton btnUpdateTokensCampany = new JButton("");
		btnUpdateTokensCampany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 0);	
				Campany c =ManageCampanyDelegate.findById((int)selectedObject);
				c.setSoldeToken(Integer.parseInt(TokensField.getText()));
				ManageCampanyDelegate.update(c);
				campanies=ManageCampanyDelegate.afficheCampany();
				initDataBindings();
			}
		});
		btnUpdateTokensCampany.setIcon(new ImageIcon(CampanyPanel.class.getResource("/com/esprit/picture/update_tokens.png")));
		
		TokensField = new JTextField();
		TokensField.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 141, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdateTokensCampany, GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
						.addComponent(TokensField, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 106, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(TokensField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdateTokensCampany, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		panel_3.setLayout(gl_panel_3);
		
		JButton btnDeleteCampany = new JButton("");
		btnDeleteCampany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected campany ?");
				if(i==0){
				int selectedRowIndex = table.getSelectedRow();
				Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 0);
				ManageCampanyDelegate.delete(ManageCampanyDelegate.findById((int)selectedObject));
				campanies=ManageCampanyDelegate.afficheCampany();
				initDataBindings();
			}}
		});
		btnDeleteCampany.setIcon(new ImageIcon(CampanyPanel.class.getResource("/com/esprit/picture/delete.png")));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Contact campany", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.inactiveCaption);
		

		final JTextArea msgArea = new JTextArea();
		msgArea.setRows(6);
		msgArea.setColumns(5);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		msgArea.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JButton btnSendMailCampany = new JButton("");
		btnSendMailCampany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 4);	
				String email = selectedObject.toString();
				Properties props = new Properties();
				 props.put("mail.smtp.host", "smtp.gmail.com");
				 props.put("mail.smtp.socketFactory.port", "587");
				 props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
				 props.put("mail.smtp.auth", "true");
				 props.put("mail.smtp.port", "587");
				 props.put("mail.smtp.ssl.enable", "false");
				 props.put("mail.smtp.starttls.enable", "true");
				 props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			        Session session = Session.getInstance(props,
			          new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication("med.b.amor@esprit.tn", "ronerts512");
			            }
			          });
		        	
			        try {

						
			            Message message = new MimeMessage(session);
			            message.setFrom(new InternetAddress("med.b.amor@esprit.tn"));
			            message.setRecipients(Message.RecipientType.TO,
			                InternetAddress.parse(email));
			            message.setSubject(subjectField.getText().toString());
			            message.setText(msgArea.getText().toString());

			            Transport.send(message);

			            JOptionPane.showMessageDialog(null, "Mail sent successfuly ");
			          

			        } 

			        catch (MessagingException x) 
			        {
			            // throw new RuntimeException(e);
			            System.out.println("Username or Password are incorrect ... exiting !");
			        }
			}
		});
		btnSendMailCampany.setIcon(new ImageIcon(CampanyPanel.class.getResource("/com/esprit/picture/send_mail.png")));
		
		
		JLabel label_6 = new JLabel("Subject");
		
		subjectField = new JTextField();
		subjectField.setColumns(10);
		
		JLabel label_7 = new JLabel("Message");
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(subjectField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(msgArea, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSendMailCampany, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(20)
					.addComponent(label_6)
					.addGap(11)
					.addComponent(subjectField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(label_7)
					.addGap(11)
					.addComponent(msgArea, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSendMailCampany, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteCampany, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE)))
							.addGap(26)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(btnDeleteCampany, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
					.addGap(135))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		initDataBindings();
	}
	
	protected void initDataBindings() {
		JTableBinding<Campany, List<Campany>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, campanies, table);
		BeanProperty<Campany, Integer> photoBeanProperty = BeanProperty.create("idUser");
		jTableBinding.addColumnBinding(photoBeanProperty).setColumnName("Campany id");
		
		BeanProperty<Campany, Integer> photoBeanProperty1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(photoBeanProperty1).setColumnName("Name");
		
		BeanProperty<Campany, Integer> photoBeanProperty2 = BeanProperty.create("matricule");
		jTableBinding.addColumnBinding(photoBeanProperty2).setColumnName("Regimental");

		BeanProperty<Campany, Integer> photoBeanProperty3 = BeanProperty.create("phone");
		jTableBinding.addColumnBinding(photoBeanProperty3).setColumnName("Phone");
		
		BeanProperty<Campany, Integer> photoBeanProperty4 = BeanProperty.create("mail");
		jTableBinding.addColumnBinding(photoBeanProperty4).setColumnName("Mail");
		
		BeanProperty<Campany, Integer> photoBeanProperty5 = BeanProperty.create("adresse");
		jTableBinding.addColumnBinding(photoBeanProperty5).setColumnName("Adress");
		
		BeanProperty<Campany, Integer> photoBeanProperty6 = BeanProperty.create("soldeToken");
		jTableBinding.addColumnBinding(photoBeanProperty6).setColumnName("Tokens");
		
		jTableBinding.bind();
		
	}

}
