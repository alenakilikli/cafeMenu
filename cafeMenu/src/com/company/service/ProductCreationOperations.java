package com.company.service;

import com.company.entity.Product;

import java.io.*;
import java.util.List;

public class ProductCreationOperations {

    public void saveToProductList(List<Product> products) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter("cafe/products.cafe")) {
            products
                    .forEach(
                            p -> pw.println(p.getName() + "^" + getProductPath(p) + "^" + p.isAvailable())
//                            p -> pw.println(
//                                    String.format(
//                                            "%s^%s^%s",
//                                            p.getName(),
//                                            findPath(p),
//                                            p.isAvailable()
//                                    ))
                    );
        }
    }

    public Product parseProduct(String s) {
        String[] p = s.split(" ");
        return new Product(p[0], Integer.parseInt(p[1]), p[2], p[3], Boolean.parseBoolean(p[4]));
    }


    public String getProductPath(Product product) {
        return "cafe/products/" + product.getCategory() + "/" + product.getName() + ".cafe";
    }

    public void createProduct(Product product) throws IOException {

        String categoryDirectoryPath = "cafe/products/" + product.getCategory();
        String productFilePath = categoryDirectoryPath + "/" + product.getName() + ".cafe";

        createCategoryDirectory(categoryDirectoryPath);
        createProduct(productFilePath);
        saveProductInfo(productFilePath, product);
    }

    private void createCategoryDirectory(String categoryPath) {
        File categoryDirectory = new File(categoryPath);
        if (!categoryDirectory.exists() || !categoryDirectory.isDirectory()) {
            categoryDirectory.mkdir();
        }
    }

    private void createProduct(String productPath) throws IOException {
        File file = new File(productPath);
        if (!file.isFile() || !file.exists()) {
            file.createNewFile();
        }
    }

    private void saveProductInfo(String productFilePath, Product product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productFilePath))) {

            writer.write(product.toString());
            writer.flush();
        }
    }


}
