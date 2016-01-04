package ie.gmit.view;

import javax.swing.*;

import javax.swing.border.TitledBorder;

import ie.gmit.sw.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AboutFrame aboutFrame = new AboutFrame();
	private HowToFrame howToFrame = new HowToFrame();
	
	private StopWordMap swm = StopWordMap.getInstance();
	private WordCloudMap wcm;
	
	private JTextField txtFilePath;
	private JTextField txtURL;
	
	public MainFrame() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pnGenerateFromFile = new JPanel();
		pnGenerateFromFile.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Generate from File", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnGenerateFromFile.setBounds(12, 13, 395, 227);
		getContentPane().add(pnGenerateFromFile);
		pnGenerateFromFile.setLayout(null);
		
		txtFilePath = new JTextField();
		txtFilePath.setText("./assignment-description.txt");
		txtFilePath.setBounds(12, 40, 260, 22);
		pnGenerateFromFile.add(txtFilePath);
		txtFilePath.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
            	JFileChooser fc = new JFileChooser("./");
            	
            	int returnVal = fc.showOpenDialog(MainFrame.this);
            	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            	if (returnVal == JFileChooser.APPROVE_OPTION) {
            		File file = fc.getSelectedFile();
            		txtFilePath.setText(file.getAbsolutePath());
            	}
			}
		});
		btnBrowse.setBounds(284, 39, 100, 25);
		pnGenerateFromFile.add(btnBrowse);
		
		JButton btnGenerateFile = new JButton("Generate");
		btnGenerateFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateFileUrl(true);
			}
		});
		btnGenerateFile.setBounds(90, 75, 100, 25);
		pnGenerateFromFile.add(btnGenerateFile);
		
		JPanel pnGenerateFromWeb = new JPanel();
		pnGenerateFromWeb.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Generate from URL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnGenerateFromWeb.setBounds(419, 13, 351, 227);
		getContentPane().add(pnGenerateFromWeb);
		pnGenerateFromWeb.setLayout(null);
		
		txtURL = new JTextField();
		txtURL.setText("https://en.wikipedia.org/wiki/Tag_cloud");
		txtURL.setBounds(12, 40, 327, 22);
		pnGenerateFromWeb.add(txtURL);
		txtURL.setColumns(10);
		
		JButton btnGenerateURL = new JButton("Generate");
		btnGenerateURL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateFileUrl(false);
			}
		});
		btnGenerateURL.setBounds(89, 75, 100, 25);
		pnGenerateFromWeb.add(btnGenerateURL);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
            	JFileChooser fc = new JFileChooser("./");
            	
            	int returnVal = fc.showOpenDialog(MainFrame.this);
            	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            	if (returnVal == JFileChooser.APPROVE_OPTION) {
            		/*
            		 * Loading stop words into map
            		 */
            		File file = fc.getSelectedFile();
            		
            		try {
						swm.load(file.getAbsolutePath());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
			}
		});
		mnFile.add(mntmLoad);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutFrame.setVisible(true);
				aboutFrame.setAlwaysOnTop(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmHowTo = new JMenuItem("How To");
		mntmHowTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				howToFrame.setVisible(true);
				howToFrame.setAlwaysOnTop(true);
			}
		});
		mnHelp.add(mntmHowTo);
		
		init();
	}

	
	private void init(){
		this.setVisible(true);
		this.setSize(800, 320);
	}
	
	private void generateFileUrl(boolean var){

		setCursor(new Cursor(Cursor.WAIT_CURSOR));
    	JFileChooser fc = new JFileChooser("./");
    	
    	int returnVal = fc.showSaveDialog(MainFrame.this);
    	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    	if (returnVal == JFileChooser.APPROVE_OPTION) {
    		/*
    		 * Generate and save file
    		 */
    		File file = fc.getSelectedFile();           		
    		try {
				wcm = new WordCloudMap(swm);
				
				Word[] words = (var) ? wcm.generate(txtFilePath.getText()) : wcm.generate(txtURL.getText());				
				
        		DrawWordCloud dwc = new DrawWordCloud();
        		
        		String fileName = (file.getAbsolutePath().toLowerCase().contains(".png")) 
        				? file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf('.')) 
        						: file.getAbsolutePath();
        		
        		dwc.drawWordCloudImage(words,1000);
        		dwc.save(fileName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    		
    	}
	
	}
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}
