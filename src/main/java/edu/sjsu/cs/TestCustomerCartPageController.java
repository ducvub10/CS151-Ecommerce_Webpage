package edu.sjsu.cs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.sjsu.cs.CustomerCartPageController.cartProductCard;
import edu.sjsu.cs.User.Customer;
import edu.sjsu.cs.User.Product;

public class TestCustomerCartPageController implements Initializable {
    Customer customer;

    double totalPrice = 0;
    
    @FXML
    HBox toHome;

    @FXML
    VBox productField;

    @FXML
    Label priceLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customer = Main.getSession().getCurrentCustomer();
        toHome.setOnMouseClicked(event -> {
            try {
                PageSwitcher.switchToCustomerMainPage(event);
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            });
        displayItem();

    }

    public void displayItem(){
        productField.getChildren().clear();
        for(Product product : customer.getCart()){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CartProductCard.fxml"));
                HBox hbox = loader.load();
                TestCartProductCardController controller = (TestCartProductCardController) loader.getController();

                // Set the FXML variables
                // controller.setProductImg(prod.getImage());
                controller.setProduct(product);
                controller.makeDelete();
                controller.makeQuantField();
                
                controller.setTestCustomerCartPageController(this);
                

                productField.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        displayTotalPrice();
    }

    public void displayTotalPrice(){
        tallyTotalPrice();
        priceLabel.setText(totalPrice + " $");
    }

    private void tallyTotalPrice(){
        totalPrice = 0;
        for(Product product : customer.getCart()){
            totalPrice += product.getTotalPrice();
        }
        
    }

    public void switchToCustomerCheckoutPage(ActionEvent event) throws IOException {
        if (customer.getCart().size() == 0){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Empty Cart");
            alert.setHeaderText("Your cart is empty");
            alert.setContentText("Please add items to your cart before checking out");
            alert.showAndWait();
        }
        else{
            PageSwitcher.switchToCustomerCheckoutPage(event);
        }
    }

}
