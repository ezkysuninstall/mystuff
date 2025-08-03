package com.hazeinc.src;

import java.io.File;

public class FileExistenceCheck {
	public static boolean fileExists;
    public static void check(String[] args) {
        String filePath = Download.destinationPath; // Replace with your file path
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("The file exists.");
            fileExists = true;
            Download.destinationPath = "download2.csv";
            Download.download(args);
        } else {
            System.out.println("The file does not exist.");
            fileExists = false;
            Download.destinationPath = "download.csv";
            Download.download(args);
        }
    }
}
