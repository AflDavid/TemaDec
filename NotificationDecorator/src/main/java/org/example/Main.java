package org.example;
import java.io.*;
import java.util.Base64;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new FileDataSource();
        dataSource = new CompressionDecorator(dataSource);
        dataSource = new EncryptionDecorator(dataSource);

        String contentToWrite = "This is a test content.";
        dataSource.write("data.txt", contentToWrite);
    }
}
