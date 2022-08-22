package com.company.engine;

import java.io.IOException;
import java.util.List;

public interface MenuEngine {

    void addNewProduct();

    List<String> listAllProductsNames() throws IOException;

    List<String> listAllProductsNamesByAvilablity() throws IOException;

    String listProductInfoByPath(String filepath) throws IOException;

    void deleteProductByPath(String path) throws IOException;

    void deleteProductByLookUp(String category, String name) throws IOException;

    void updateProductInfo();

    String listProductInfoByLookUp(String category, String name) throws IOException;
}
