package com.company.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductReadingOperations {

    public static List<String> readFromFile(String path) throws IOException {
        String line;
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }

        return result;
    }
}
