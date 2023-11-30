package edu.sjsu.cs.Store_Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjsu.cs.User.Product;



public class Store {
    private static Store instance = null;
    private String name;
    private Map<String, Product> products;

    private Store(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }

    public static Store getInstance(String name) {
        if (instance == null) {
            instance = new Store(name);
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void removeProduct(Product product) {
        products.remove(product.getProductId());
    }

    public Map<String, Product> getProducts() {
        return products;
    }
}
