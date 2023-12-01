package edu.sjsu.cs;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;






public class TestCartProductCardController implements Initializable {
    private Customer customer;
    private Product currentProduct;

    private Double productPriceNum;
    @FXML
    private HBox baseHBox;
    
    @FXML
    private Label productId;

    @FXML
    private Label productPrice;

    @FXML
    private ImageView productImage;
    
    @FXML
    private Label productName;
    
    @FXML
    private Button deleteItem;
    
    @FXML
    private TextField quantityField;

    private TestCustomerCartPageController testCustomerCartPageController;

    public void setTestCustomerCartPageController(TestCustomerCartPageController testCustomerCartPageController) {
        this.testCustomerCartPageController = testCustomerCartPageController;
    }
    public void displayItem() {
        // ...
        testCustomerCartPageController.displayItem();
        // ...
    }

    // Add your code here
    
    public void initialize(URL location, ResourceBundle resources) {
            customer = Main.getSession().getCurrentCustomer();
            baseHBox.prefHeightProperty().bind(productImage.fitHeightProperty());
    }

    public void makeDelete(){
        deleteItem.setText("Delete");
        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
                 
                @Override
                public void handle(ActionEvent event){
                    customer.getCart().remove(Main.getStore().getProducts().get(currentProduct.getProductId()));
                    System.out.println("Product " + currentProduct.getName() + " deleted from cart");
                    try {
                        PageSwitcher.switchToCustomerCartPage(event);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
    }

    public void makeQuantField(){
        //quanitity field
            quantityField.setText(Integer.toString(currentProduct.getQuantity()));
            quantityField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // This code will be executed whenever the text of the TextField changes
                    System.out.println("Quantity changed from " + oldValue + " to " + newValue);
                    if(!newValue.isEmpty()){
                        currentProduct.setQuantity(Integer.parseInt(newValue));
                        currentProduct.setTotalPrice(currentProduct.getPrice() * Integer.parseInt(newValue));
                        displayItem();
                    }
                }
                });
    }
    
    
    // Add event handlers and other methods here
    public void setProduct(Product product) {
        this.currentProduct = product;
        productId.setText("Id: " + product.getProductId());
        productImage.setImage(product.getImage());
        productName.setText("Name: " + product.getName());
        productPrice.setText("Price: " + "$" + product.getPrice());
        
    }

    public double getProductPrice() {
        return productPriceNum;
    }
}
