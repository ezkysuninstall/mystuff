package com.hazeinc.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author artur
 */
public abstract class GUI implements ActionListener {
    
    private static JLabel downloadText;
    private static JTextField downloadUrl;
    private static JLabel savePathText;
    private static JLabel savePathText2;
    private static JTextField savePath;
    private static JTextField savePath2;
    private static JButton downloadButton;
    private static JButton checkButton;
    static JLabel output;
    public static String downloadURL;
    public static String savePATH;
    public static String savePATH2;

    public static void main(String[] args) {
        //shit go here
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(650,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.setLayout(null);
        
        downloadText = new JLabel("Download URL:");
        downloadText.setBounds(10,20,120,25);
        panel.add(downloadText);
        
        downloadUrl = new JTextField(20);
        downloadUrl.setBounds(120,20,300,25);
        panel.add(downloadUrl);
        
        savePathText = new JLabel("File name (1):");
        savePathText.setBounds(10,50,80,25);
        panel.add(savePathText);
        
        savePath = new JTextField();
        savePath.setBounds(120,50,200,25);
        panel.add(savePath);
        
        savePathText2 = new JLabel("File name (2)");
        savePathText2.setBounds(10,70,80,25);
        panel.add(savePathText2);
        
        savePath2 = new JTextField();
        savePath2.setBounds(120,70,200,25);
        panel.add(savePath2);
        
        downloadButton = new JButton("Download");
        downloadButton.setBounds(10,160,120,25);
        downloadButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//code for download button
        		//System.out.println("Download");
        		downloadURL = downloadUrl.getText();
        		Download.download(args);
        	}
        });
        panel.add(downloadButton);
        
        output = new JLabel("");
        output.setBounds(10,240,300,25);
        panel.add(output);
        
        checkButton = new JButton("Check");
        checkButton.setBounds(10,190,80,25);
        checkButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//code for check button
        		//System.out.println("Check");
        		savePATH = savePath.getText();
        		savePATH2 = savePath2.getText();
        		Check.check(args);
        		
        	}
        });
        panel.add(checkButton);
        
        
        
        
        frame.setVisible(true); //this gotta go at the end
    }

    
}
