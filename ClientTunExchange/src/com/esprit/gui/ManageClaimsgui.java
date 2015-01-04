package com.esprit.gui;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.esprit.delegate.ManageClaimsDelegate;
import com.esprit.pidev.jpa.Claims;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ManageClaimsgui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private List<Claims> listofclaims;
	private ManageClaimsDelegate md;
	private JTextField textField;
	private Claims cla;
	/**
	 * Create the panel.
	 */
	JInternalFrame response;
	public ManageClaimsgui(final int idadmin) {
		setBackground(SystemColor.inactiveCaption);
		md=new ManageClaimsDelegate();
		listofclaims=md.getnotresponse();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 559, 241);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
	
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(677, 385, 96, 39);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				response=new ResponseClaims(idadmin,(Integer) table.getModel().getValueAt(selectedRowIndex, 0));
				add(response);
				setComponentZOrder(response,0);
				repaint();
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageClaimsgui.class.getResource("/com/esprit/picture/Reply.png")));
		
		textField = new JTextField();
		textField.setBounds(479, 19, 100, 31);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				listofclaims=md.findclaimbyname(textField.getText());
				initDataBindings();
			}
		});
		textField.setColumns(10);
		
		JLabel lblRecherche = new JLabel("Find By Name");
		lblRecherche.setBounds(374, 24, 95, 17);
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(10, 11, 136, 39);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(ManageClaimsgui.class.getResource("/com/esprit/picture/allclaims.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listofclaims=md.getallClaims();
				initDataBindings();
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(174, 11, 156, 39);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofclaims=md.getnotresponse();
				initDataBindings();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageClaimsgui.class.getResource("/com/esprit/picture/newclaims.png")));
		
		setLayout(null);
		add(btnNewButton);
		add(scrollPane);
		add(btnNewButton_1);
		add(btnNewButton_2);
		add(lblRecherche);
		add(textField);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel.setBounds(603, 49, 298, 279);
		add(panel);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(16, 62, 37, 14);
		
		final JTextPane name = new JTextPane();
		name.setBounds(73, 27, 193, 20);
		name.setEditable(false);
		name.setBackground(Color.WHITE);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(16, 33, 47, 14);
		
		final JTextPane subject = new JTextPane();
		subject.setBounds(73, 92, 193, 20);
		subject.setEditable(false);
		subject.setBackground(Color.WHITE);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(16, 98, 47, 14);
		
		final JTextPane content = new JTextPane();
		content.setBounds(73, 123, 193, 127);
		content.setEditable(false);
		content.setBackground(Color.WHITE);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(16, 123, 47, 14);
		panel.setLayout(null);
		panel.add(name);
		panel.add(lblName);
		
		
		
		final JTextPane Mail = new JTextPane();
		Mail.setBounds(73, 58, 193, 20);
		panel.add(Mail);
		Mail.setEditable(false);
		Mail.setBackground(Color.WHITE);
		panel.add(subject);
		panel.add(lblSubject);
		panel.add(content);
		panel.add(lblContent);
		panel.add(lblMail);
		

		final JButton showresponse = new JButton("");
		showresponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame rs=new ResponseClaimsshow(cla);
				add(rs);
				setComponentZOrder(rs,0);
				repaint();
			}
		});
		showresponse.setIcon(new ImageIcon(ManageClaimsgui.class.getResource("/com/esprit/picture/showresponse.png")));
		showresponse.setBounds(418, 385, 197, 39);
		add(showresponse);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int selectedRowIndex = table.getSelectedRow();
				name.setText((String) table.getModel().getValueAt(selectedRowIndex, 1));
				subject.setText((String) table.getModel().getValueAt(selectedRowIndex, 2));
				Mail.setText((String) table.getModel().getValueAt(selectedRowIndex, 3));
				content.setText((String) table.getModel().getValueAt(selectedRowIndex, 4));
				cla=md.getClaimsbyid((Integer) table.getModel().getValueAt(selectedRowIndex, 0));
				if(cla.getEtat()){
					showresponse.setEnabled(true);
				}else{
					showresponse.setEnabled(false);
				}
				
			}
		});
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Claims, List<Claims>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listofclaims, table);
		//
		BeanProperty<Claims, Integer> claimsBeanProperty = BeanProperty.create("idClaims");
		jTableBinding.addColumnBinding(claimsBeanProperty).setColumnName("ID Claims");
		//
		BeanProperty<Claims, String> claimsBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(claimsBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Claims, String> claimsBeanProperty_2 = BeanProperty.create("subject");
		jTableBinding.addColumnBinding(claimsBeanProperty_2).setColumnName("Subject");
		//
		BeanProperty<Claims, String> claimsBeanProperty_3 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(claimsBeanProperty_3).setColumnName("E-Mail");
		//
		BeanProperty<Claims, String> claimsBeanProperty_4 = BeanProperty.create("content");
		jTableBinding.addColumnBinding(claimsBeanProperty_4).setColumnName("Content");
		//
		jTableBinding.bind();
	}
}
