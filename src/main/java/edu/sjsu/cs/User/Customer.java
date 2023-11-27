package edu.sjsu.cs.User;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cs.Behaviors.AddProduct;

/**
 * Customer
 */
public class Customer extends User {
    private String address;
    public List<Product> cart;
    // private AddProduct addProduct;
    // private RemoveProduct removeProduct;
    // private EditProduct editProduct;

    public Customer(String username, String password, String email, String address, String phone) {
        super(username, password, email, phone);
        this.address = address;
        cart = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    // public void setAddProduct(AddProduct addProduct) {
    //     this.addProduct = addProduct;
    // }

    public void addProduct(Product product) {
        cart.add(product);
    }

}

