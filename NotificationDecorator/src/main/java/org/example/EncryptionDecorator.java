package org.example;
import java.io.*;
import java.util.Base64;
import java.util.zip.*;

class EncryptionDecorator implements DataSource {
    private DataSource dataSource;

    EncryptionDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void read(String filePath) {
        dataSource.read(filePath);
    }

    public void write(String filePath, String content) {
        // Encrypt the content
        String encryptedContent = Base64.getEncoder().encodeToString(content.getBytes());
        dataSource.write(filePath, encryptedContent);
    }
}

