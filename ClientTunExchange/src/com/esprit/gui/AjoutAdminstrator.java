package com.esprit.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class AjoutAdminstrator extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutAdminstrator frame = new AjoutAdminstrator();
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
	public AjoutAdminstrator() {
		setBounds(100, 100, 485, 474);
	setContentPane(new AjouterAdmin());	
		

	}

}
