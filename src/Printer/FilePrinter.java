package Printer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilePrinter implements Printer {
    protected String fileName;
    public FilePrinter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(List<String> keys) {
        final File file = new File(fileName);
        try (java.io.FileWriter fw = new java.io.FileWriter(file, true)) {
            keys.forEach(k -> {
                try {
                    fw.write(k + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}
