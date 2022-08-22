package com.company.engine;

import com.company.service.ProductCreationOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MenuEngineImpl implements MenuEngine {

    private static final String PATH = "/cafe/products.cafe";

    private static final ProductCreationOperations operations = new ProductCreationOperations();

    @Override
    public void addNewProduct() {

    }

    @Override
    public List<String> listAllProductsNames() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(operations.parseProduct(line).getName());
            }
            return res;

        }

    }

    @Override
    public List<String> listAllProductsNamesByAvilablity() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (operations.parseProduct(line).isAvailable())
                    res.add(line);
            }
            return res;

        }

    }

    @Override
    public String listProductInfoByPath(String filepath) throws IOException {
        String s = "";
        File file = new File(filepath);
        if (!file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
                String line;
                while ((line = br.readLine()) != null) {
                    s = line;
                }
            }
        } else {
            throw new FileNotFoundException();
        }

        return s;
    }

    @Override
    public void deleteProductByPath(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (operations.getProductPath(operations.parseProduct(line)).equals(path)) {
                    line = null;
                } else {
                    throw new FileNotFoundException();
                }

            }

        }
    }

    @Override
    public void deleteProductByLookUp(String category, String name) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (operations.parseProduct(line).getCategory().equals(category) && operations.parseProduct(line).getName().equals(name)) {
                    line = null;
                } else {
                    throw new FileNotFoundException();
                }

            }

        }
    }

    @Override
    public void updateProductInfo() {

    }

    @Override
    public String listProductInfoByLookUp(String category, String name) throws IOException {
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (operations.parseProduct(line).getCategory().equals(category) && operations.parseProduct(line).getName().equals(name)) {
                    s = line;
                } else {
                    throw new FileNotFoundException();
                }

            }

        }
        return s;

    }
}
