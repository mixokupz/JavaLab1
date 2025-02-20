package org.example;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;


public class CsvReader {
    public StringBuilder readingTXT(String source) {
        Reader reader = null;
        StringBuilder string = new StringBuilder();
        try {
            reader = new InputStreamReader(new FileInputStream(source));
            int int_string =0;
            //считывание слов из файла
            while ((int_string = reader.read()) != -1) {
                string.append((char)int_string);
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return string;
    }
}