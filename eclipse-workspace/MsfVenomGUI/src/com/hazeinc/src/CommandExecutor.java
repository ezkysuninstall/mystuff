package com.hazeinc.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;

public class CommandExecutor {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");
            

            // Example: List files in the current directory (Linux/macOS)
            processBuilder.command(GUI.sysCommand);

            // Example: List files in a specific directory (Windows)
            // processBuilder.command("cmd.exe", "/c", "dir", "C:\\Users\\YourUser\\Documents");

            Process process = processBuilder.start();

            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read error output (if any)
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println("Error: " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
