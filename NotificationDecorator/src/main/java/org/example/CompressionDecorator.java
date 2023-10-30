package org.example;
import java.io.*;
import java.util.Base64;
import java.util.zip.*;

class CompressionDecorator implements DataSource {
    private DataSource dataSource;

    CompressionDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void read(String filePath) {
        dataSource.read(filePath);
    }

    public void write(String filePath, String content) {
        // Compress the content
        byte[] compressedContent = content.getBytes();
        Deflater deflater = new Deflater();
        deflater.setInput(compressedContent);
        deflater.finish();
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        deflater.end();
        dataSource.write(filePath, outputStream.toString());
    }
}