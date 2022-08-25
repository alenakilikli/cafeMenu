package com.company.engine;

import com.company.entity.Product;

import java.io.IOException;
import java.util.List;

public interface MenuEngine {
    void addNewProduct(Product product) throws IOException;

    List<String> listAllProductsNames(String path) throws IOException;

    List<String> listAllProductsNamesByAvilablity(String path) throws IOException;

    String listProductInfoByPath(String path) throws IOException;

    String listProductInfoByLookUp(String category, String name) throws IOException;

    void deleteProductByPath(String path) throws IOException;

    void deleteProductByLookUp(String category, String name) throws IOException;

//    void addNewProduct();
//
//    List<String> listAllProductsNames() throws IOException;
//
//    List<String> listAllProductsNamesByAvilablity() throws IOException;
//
//    String listProductInfoByPath(String filepath) throws IOException;
//
//    void deleteProductByPath(String path) throws IOException;
//
//    void deleteProductByLookUp(String category, String name) throws IOException;
//
//    void updateProductInfo();
//
//    String listProductInfoByLookUp(String category, String name) throws IOException;
}
