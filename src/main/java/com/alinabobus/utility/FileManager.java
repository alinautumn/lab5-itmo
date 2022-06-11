package com.alinabobus.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private final String filename;

    public FileManager(String var) {
        this.filename = System.getenv(var);
        try {
            if (!filename.endsWith(".json")) {
                System.out.println("This program can only work with .json file.");
                return;
            }
        } catch (NullPointerException e) {
            System.out.println("The environment variable is invalid. Set it to PROG_PATH.");
            return;
        }
    }

    public String getFilename() {
        return filename;
    }

    public String read() throws IOException {
        StringBuilder strData = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                strData.append(scanner.nextLine() + ",");
            }
        }
        return strData.toString();
    }

    public void save(String text) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
