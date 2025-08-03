package com.hazeinc.src;

import java.io.FileInputStream;
import java.io.IOException;

public class Check {
	
	static boolean filesEqual;
	
	public static boolean areCsvFilesByteIdentical(String file1Path, String file2Path) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(GUI.savePATH);
             FileInputStream fis2 = new FileInputStream(GUI.savePATH2)) {

            int byte1;
            int byte2;

            while ((byte1 = fis1.read()) != -1) {
                byte2 = fis2.read();
                if (byte2 == -1 || byte1 != byte2) {
                    return false; // Files differ in content or length
                }
            }
            // Check if file2 also reached its end
            return fis2.read() == -1; 

        }
	}

	public static void check(String[] args) {
		// TODO Auto-generated method stub
		try {
            boolean identical = areCsvFilesByteIdentical(GUI.savePATH, GUI.savePATH2);
            if (identical) {
                System.out.println("The CSV files are byte-identical.");
                filesEqual = true;
                GUI.output.setText("Files are equal");
            } else {
                System.out.println("The CSV files are NOT byte-identical.");
                filesEqual = false;
                GUI.output.setText("Files are not equal");
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }

	}

}
