package com.hazeinc.src;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RuntimeExecutor {
    public static void main(String[] args) {
        try {
            // Example: Listing files in the current directory
            String command = GUI.sysCommand; // For Windows: "cmd.exe /c dir"
            Process process = Runtime.getRuntime().exec(command);

            // Read the output (similar to ProcessBuilder example)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nCommand exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
