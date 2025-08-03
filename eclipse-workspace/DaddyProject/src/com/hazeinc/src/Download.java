package com.hazeinc.src;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Download {
	
	public static String destinationPath;

		// TODO Auto-generated method stub
		public static void downloadUsingStream(String urlStr, String file) throws IOException {
	        URL url = new URL(urlStr);
	        BufferedInputStream bis = new BufferedInputStream(url.openStream());
	        FileOutputStream fos = new FileOutputStream(file);
	        byte[] buffer = new byte[1024];
	        int count = 0;
	        while ((count = bis.read(buffer, 0, 1024)) != -1) {
	            fos.write(buffer, 0, count);
	        }
	        fos.close();
	        bis.close();
	    }
	    
	    public static void download(String[] args) {
	        String fileUrl = GUI.downloadURL; // Replace with your file URL
	        destinationPath = "download.csv"; // Replace with your desired local path
	        //String destinationPath2 = "download2.csv";
	        
	        String filePath = destinationPath; // Replace with your file path
	        File file = new File(filePath);
	        
	        if (file.exists()) {
	        	try {
		            downloadUsingStream(fileUrl, "download2.csv");
		            //downloadUsingStream(fileUrl, destinationPath2);
		            System.out.println("File downloaded successfully!");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	        } else {
	        	try {
		            downloadUsingStream(fileUrl, "download.csv");
		            //downloadUsingStream(fileUrl, destinationPath2);
		            System.out.println("File downloaded successfully!");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	        }
	        

	        
	        

	}

}
