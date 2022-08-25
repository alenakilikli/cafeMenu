package com.company.service;

import com.company.entity.Product;

import java.io.*;
import java.util.List;

public class ProductCreationOperations {

    final String productsListFile = "cafe" + File.separator + "products.cafe";

    Product product;

    final String currentProductPath = File.separator + product.getName() + ".cafe";
    String categoryPath = "cafe" + File.separator + "products" + File.separator + product.getCategory();

    public void saveToProductList(List<Product> products) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter("cafe/products.cafe")) {
            products
                    .forEach(

                            p -> pw.println(
                                    String.format(
                                            "%s^%s^%s",
                                            p.getName(),
                                            getProductPath(p),
                                            p.isAvailable()
                                    ))
                    );
        }
    }



    public String getProductPath(Product product) {
        return categoryPath + product.getCategory() + "/" + product.getName() + ".cafe";
    }

    public void createProduct(Product product) throws IOException {

        String categoryDirectoryPath = categoryPath;
        String productFilePath = categoryDirectoryPath + currentProductPath;

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

    private void saveProductInfo(String productPath, Product product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productPath))) {

            writer.write(product.toString());
            writer.flush();
        }
    }


}
