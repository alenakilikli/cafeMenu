package service;

import entity.Product;

import java.io.*;
import java.util.List;

public class FileCreationOperations {
    public static void main(String[] args) {

    }

    /**
     * Writes the strings into the file, one row as one line
     *
     * @param products
     * @param filename
     */
    public static void writeToFile(List<Product> products, String filename) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Product p : products) {
                pw.println(p.getName() + " * " + findPath(p) + " * " + p.isAvailable());
                System.out.println("created");
            }
        }
    }
    public static Product stringToProduct(String s) {
        String[] p = s.split(" ");
        return new Product(p[0], Integer.parseInt(p[1]), p[2], p[3], Boolean.parseBoolean(p[4]));
    }


    public static String findPath(Product product) {
        return "cafe/products/" + product.getCategory() + "/" + product.getName() + ".cafe";
    }

    /**
     * create a directory from productCategory and make file inside with whole info
     *
     * @param product
     * @throws IOException
     */
    public static void createDirectory(Product product) throws IOException {

        String pathDirectory = "cafe/product/ " + product.getCategory();
        String pathFileName = pathDirectory + "/" + product.getName() + ".cafe";

        File directory = new File(pathDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            directory.mkdir();
        }

        File file = new File(pathFileName);
        if (!file.isFile() || !file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fileWriter = new FileWriter(pathFileName);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(product.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
