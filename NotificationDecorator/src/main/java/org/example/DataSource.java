package org.example;
import java.io.*;
import java.util.Base64;
import java.util.zip.*;

public interface DataSource {
    void read(String filePath);
    void write(String filePath, String content);
}
