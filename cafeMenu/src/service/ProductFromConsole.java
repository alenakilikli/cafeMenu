package service;

import entity.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static service.FileCreationOperations.stringToProduct;

public class ProductFromConsole {
    public static void main(String[] args) throws IOException {
        List<Product> products = readFromConsole();

        for (Product p : products) {
            FileCreationOperations.createDirectory(p);
            FileCreationOperations.writeToFile(products, "cafe/products.cafe");
        }

    }

    private static List<Product> readFromConsole() throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            List<Product> res = new ArrayList<>();

            String line;
            while ((line = bf.readLine()) != null && !line.equals("exit")) {
                res.add(stringToProduct(line));
            }
            return res;
        }
    }


}
