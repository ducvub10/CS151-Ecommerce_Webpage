package edu.sjsu.cs;

import java.net.URL;
import java.util.ResourceBundle;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ProductCardController implements Initializable{
    Product currentProduct;
    
    @FXML 
    private ImageView productImg;

    @FXML
    private Label productName;

    @FXML
    private Label productDesc;

    @FXML
    private Button addToCart;

    @FXML
    private VBox productCardBase;

    @FXML 
    private Label productPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

    public void setProduct(Product product) {
        currentProduct = product;
        productImg.setImage(product.getImage());
        productName.setText(product.getName());
        productDesc.setText(product.getDescription());
        productPrice.setText("$" + product.getPrice());
    }

    public void setProductImg(Image image) {
        productImg.setImage(image);
    }

    public void setProductName(String name) {
        productName.setText(name);
    }

    public void setProductDesc(String desc) {
        productDesc.setText(desc);
    }

    public void setProductPrice(double price) {
        productPrice.setText("$" + price);
    }

    public void addToCartHandler(ActionEvent event){
        if (Main.getSession().getCurrentCustomer().getCart().contains(Main.getStore().getProducts().get(currentProduct.getProductId()))){
            Main.getSession().getCurrentCustomer().getCart().get(Main.getSession().getCurrentCustomer().getCart().indexOf(Main.getStore().getProducts().get(currentProduct.getProductId()))).setQuantity(Main.getSession().getCurrentCustomer().getCart().get(Main.getSession().getCurrentCustomer().getCart().indexOf(Main.getStore().getProducts().get(currentProduct.getProductId()))).getQuantity() + 1);
            System.out.println("Product " + currentProduct.getName() + " increased quantity in cart");
        }
        else{
            Main.getSession().getCurrentCustomer().getCart().add(Main.getStore().getProducts().get(currentProduct.getProductId()));
            Main.getSession().getCurrentCustomer().getCart().get(Main.getSession().getCurrentCustomer().getCart().indexOf(Main.getStore().getProducts().get(currentProduct.getProductId()))).setQuantity(1);
            System.out.println("Product " + currentProduct.getName() + " added to cart");
        }
    }
}
