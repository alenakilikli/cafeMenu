package com.company.engine;

import com.company.entity.Product;
import com.company.service.ProductCreationOperations;
import com.company.service.ProductReadingOperations;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class MenuEngineImpl implements MenuEngine {


    @Override
    public void addNewProduct(Product product) throws IOException {
        new ProductCreationOperations().createProduct(product);
    }

    @Override
    public List<String> listAllProductsNames(String path) throws IOException {
        return ProductReadingOperations.readFromFile(path).stream()
                .map(p -> parseProduct(p)
                        .getName())
                .collect(Collectors.toList());

    }

    private Product parseProduct(String s) {
        String[] p = s.split(" ");
        return new Product(p[0], Integer.parseInt(p[1]), p[2], p[3], Boolean.parseBoolean(p[4]));
    }

    @Override
    public List<String> listAllProductsNamesByAvilablity(String path) throws IOException {
        return ProductReadingOperations.readFromFile(path).stream()
                .map(this::parseProduct)
                .filter(Product::isAvailable)
                .map(Product::getName).toList();

    }

    @Override
    public String listProductInfoByPath(String path) throws IOException {
        return ProductReadingOperations.readFromFile(path).toString();

    }


    @Override
    public String listProductInfoByLookUp(String category, String name) throws IOException {
        String path = String.format("cafe/products/%s/%s.cafe", category, name);
        return listProductInfoByPath(path);
    }

    @Override
    public void deleteProductByPath(String path) throws IOException {
        File file = new File(path);
        file.delete();
    }

    @Override
    public void deleteProductByLookUp(String category, String name) throws IOException {
        String path = String.format("cafe/products/%s/%s.cafe", category, name);
        deleteProductByPath(path);
    }

//    @Override
//    public void updateProductInfo() {
//
//    }

}
