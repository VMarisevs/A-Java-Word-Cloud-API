package ie.gmit.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class HowToFrame extends JFrame {

	public HowToFrame() {
		setTitle("How To");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 558, 327);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWordCloudAPI = new JLabel("Word Cloud API");
		lblWordCloudAPI.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblWordCloudAPI.setBounds(12, 13, 380, 65);
		panel.add(lblWordCloudAPI);
		
		JLabel lblHelp1 = new JLabel("1) Load stop words. File => Load, Open \"stopwords.txt\" or similar.");
		lblHelp1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHelp1.setBounds(12, 100, 534, 40);
		panel.add(lblHelp1);
		
		JLabel lblHelp2 = new JLabel("2) Copy URL  or use Browse button to locate file.");
		lblHelp2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHelp2.setBounds(12, 140, 380, 40);
		panel.add(lblHelp2);
		
		JLabel lblHelp3 = new JLabel("3) Click \"Generate\" and type file name.");
		lblHelp3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHelp3.setBounds(12, 180, 380, 40);
		panel.add(lblHelp3);
		
		JLabel lblHelp4 = new JLabel("Note, file extension *.png will be added automatically.");
		lblHelp4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHelp4.setBounds(12, 220, 380, 40);
		panel.add(lblHelp4);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				setAlwaysOnTop(false);
			}
		});
		btnOK.setBounds(220, 350, 100, 30);
		getContentPane().add(btnOK);
		
		init();
	}
	
	
	private void init(){
		this.setSize(600, 450);
	}
}
