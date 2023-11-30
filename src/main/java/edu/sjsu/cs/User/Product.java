package edu.sjsu.cs.User;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Product {
    private String productId;
    private Image image;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private double totalPrice;

    public Product(String productId, String name, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = 1;
        totalPrice = price * quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Image getImage(){
        return image;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
}

