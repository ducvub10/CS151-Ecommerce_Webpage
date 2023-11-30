package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerProfileController implements Initializable {
    @FXML 
    Label usernameField;    

    @FXML 
    Label passwordField;

    @FXML 
    Label emailField;

    @FXML 
    Label addressField;

    @FXML 
    Label phoneField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setText(Main.getSession().getCurrentCustomer().getUsername());
        passwordField.setText(Main.getSession().getCurrentCustomer().getPassword());
        emailField.setText(Main.getSession().getCurrentCustomer().getEmail());
        addressField.setText(Main.getSession().getCurrentCustomer().getAddress());
        phoneField.setText(Main.getSession().getCurrentCustomer().getPhone());
    }

    public void switchToCustomerMain(ActionEvent event) throws IOException {
        this.root = (Parent) FXMLLoader.load(this.getClass().getResource("TestCustomerMainPage1.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
