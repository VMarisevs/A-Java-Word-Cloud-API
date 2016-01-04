package ie.gmit.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Color;
import java.awt.Desktop;

public class AboutFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public AboutFrame() {
		setResizable(false);
		setType(Type.POPUP);
		setTitle("About");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 558, 350);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWordCloudAPI = new JLabel("Word Cloud API");
		lblWordCloudAPI.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblWordCloudAPI.setBounds(12, 13, 380, 65);
		panel.add(lblWordCloudAPI);
		
		JLabel lblPreparedBy = new JLabel("Prepared by: Vladislavs Marisevs");
		lblPreparedBy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPreparedBy.setBounds(12, 100, 380, 40);
		panel.add(lblPreparedBy);
		
		JLabel lblForTheAttention = new JLabel("For the attention of: John Healy");
		lblForTheAttention.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblForTheAttention.setBounds(12, 140, 380, 40);
		panel.add(lblForTheAttention);
		
		JLabel lblClasshonsSoftware = new JLabel("Class: (Hons) Software Development year 4");
		lblClasshonsSoftware.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblClasshonsSoftware.setBounds(12, 180, 380, 40);
		panel.add(lblClasshonsSoftware);
		
		JLabel lblCollegeGalwayMayo = new JLabel("College: Galway Mayo Institute of Technology");
		lblCollegeGalwayMayo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCollegeGalwayMayo.setBounds(12, 220, 380, 40);
		panel.add(lblCollegeGalwayMayo);
		
		JLabel lblSubmissionDateJanuary = new JLabel("Submission Date: January 10th 2016");
		lblSubmissionDateJanuary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSubmissionDateJanuary.setBounds(12, 260, 380, 40);
		panel.add(lblSubmissionDateJanuary);
		
		JButton btnGithub = new JButton("Open GitHub: https://github.com/VMarisevs/A-Java-Word-Cloud-API");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Open on GitHub
				 */
				 Desktop desktop = Desktop.getDesktop();
				 try {
					desktop.browse(new URI("https://github.com/VMarisevs/A-Java-Word-Cloud-API"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		btnGithub.setBounds(12, 312, 534, 25);
		panel.add(btnGithub);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setAlwaysOnTop(false);
			}
		});
		btnOK.setBounds(221, 376, 100, 30);
		getContentPane().add(btnOK);
		
		init();
	}
	
	
	private void init(){
		this.setSize(600, 450);
	}
}
