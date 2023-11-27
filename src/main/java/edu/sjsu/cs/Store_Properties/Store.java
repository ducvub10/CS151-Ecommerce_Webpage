package edu.sjsu.cs.Store_Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjsu.cs.User.Product;



public class Store {
    private String name;
    private Map<String, Product> products;

    public Store(String name) {
        this.name = name;
        this.products = new HashMap<>();
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

    // public void displayProducts() {
    //     System.out.println("Products available in " + name + ":");
    //     for (Product product : products.entrySet()) {
    //         System.out.println(product.getName() + " - $" + product.getPrice());
    //     }
    // }
}
