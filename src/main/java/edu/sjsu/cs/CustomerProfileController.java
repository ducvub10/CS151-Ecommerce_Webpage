package edu.sjsu.cs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameField.setText(Main.getSession().getCurrentCustomer().getUsername());
        passwordField.setText(Main.getSession().getCurrentCustomer().getPassword());
        emailField.setText(Main.getSession().getCurrentCustomer().getEmail());
        addressField.setText(Main.getSession().getCurrentCustomer().getAddress());
        phoneField.setText(Main.getSession().getCurrentCustomer().getPhone());
    }
}
