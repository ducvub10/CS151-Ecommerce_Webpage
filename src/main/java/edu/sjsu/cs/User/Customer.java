package edu.sjsu.cs.User;

import java.util.ArrayList;
import java.util.List;

// import edu.sjsu.cs.Behaviors.AddProduct;

/**
 * Customer
 */
public class Customer extends User {
    private String address;
    private List<Product> cart;
    private List<Order> orderHistory;
    // private AddProduct addProduct;
    // private RemoveProduct removeProduct;
    // private EditProduct editProduct;

    public Customer(String username, String password, String email, String address, String phone) {
        super(username, password, email, phone);
        this.address = address;
        cart = new ArrayList<>();
        orderHistory = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
    
    // public void setAddProduct(AddProduct addProduct) {
    //     this.addProduct = addProduct;
    // }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void removeOrder(Order order) {
        orderHistory.remove(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }


}

