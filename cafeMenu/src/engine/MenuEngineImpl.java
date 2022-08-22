package engine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static service.FileCreationOperations.findPath;
import static service.FileCreationOperations.stringToProduct;


public class MenuEngineImpl implements MenuEngine {

    static final String PATH = "/cafe/products.cafe";

    @Override
    public void addNewProduct() {

    }

    @Override
    public List<String> listAllProductsNames() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                res.add(stringToProduct(line).getName());
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
                if (stringToProduct(line).isAvailable())
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
                if (findPath(stringToProduct(line)).equals(path)) {
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
                if (stringToProduct(line).getCategory().equals(category) && stringToProduct(line).getName().equals(name)) {
                    line = null;
                } else {
                    throw new FileNotFoundException();
                }

            }

        }
    }

    @Override
    public void UpdateProductInfo() {

    }

    @Override
    public String listProductInfoByLookUp(String category, String name) throws IOException {
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (stringToProduct(line).getCategory().equals(category) && stringToProduct(line).getName().equals(name)) {
                    s = line;
                } else {
                    throw new FileNotFoundException();
                }

            }

        }
        return s;

    }
}
