package store;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import User.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjsu.cs.User.Product;

public class Store {

    public static void shoppingProcess(Subproducts subproduct, Customer current){
        Product [] allProducts = subproduct.getListOfProducts();
        showProducts(allProducts);
        addToCart(allProducts, current)

    }
    public static void showProducts(Product [] allProducts){
        for(int i = 0; i < allProducts.length; i++){
            System.out.println(allProducts[i].getProductID() + " " + allProducts[i].getProductName() + " " + allProducts[i].getCost());
        }
    }
    public static Product [] addToCart(){

    }
    public static void checkOut(){

    }
    public static void addSellerProducts(){

    }
    public static Customer createCustomer(){

    }
    public static void createSeller(){

    }
    public static void createAdmin(){

    }
    public static void main(String[] args) {

    }
}
