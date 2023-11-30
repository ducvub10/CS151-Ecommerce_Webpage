package edu.sjsu.cs;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.sjsu.cs.User.Customer;

import edu.sjsu.cs.Store_Properties.Store;

public class CustomerCheckoutPageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Store store;
    private Customer customer;

    @FXML
    private Button payButton;

    public void payNowHandler(ActionEvent event) throws IOException {
        customer.addOrder(Main.getSession().getCurrentOrder());
        customer.getCart().clear();
        Main.getSession().setCurrentOrder(null);
        switchToOrderHistory(event);
    }

    private void switchToOrderHistory(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerOrderHistory.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code 
        customer = Main.getSession().getCurrentCustomer();    
    }
}


