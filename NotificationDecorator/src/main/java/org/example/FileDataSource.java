package org.example;
import java.io.*;
import java.util.Base64;
import java.util.zip.*;

class FileDataSource implements DataSource {
    public void read(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filePath + "' not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public void write(String filePath, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
            System.out.println("Content successfully written to '" + filePath + "'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
