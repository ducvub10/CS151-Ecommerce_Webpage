package edu.sjsu.cs.User;

import java.util.List;

public class Order {
    private String orderID;
    private List<Product> products;
    private double totalPrice;

    public Order(String orderID, List<Product> products, double totalPrice) {
        this.orderID = orderID;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Order() {

    }

    public String getOrderID() {

        return orderID;
    }

    public void setOrderID(String orderID) {

        this.orderID = orderID;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {

        this.totalPrice = totalPrice;
    }

    
}
