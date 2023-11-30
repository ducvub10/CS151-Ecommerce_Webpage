package edu.sjsu.cs;

import edu.sjsu.cs.User.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static edu.sjsu.cs.Behaviors.Session.currentCustomer;

public class CustomerLoginController extends SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public CustomerLoginController() {
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (this.isValidLogin(username, password)) {
            this.switchToCustomerMainPage(event);
        }

    }

    public boolean isValidLogin(String username, String password){
        for (Customer customer: customers){
            if (customer.getUsername().equals(username)){
                if (customer.getPassword().equals(password)){
                    currentCustomer = new Customer(customer.getUsername(), customer.getPassword(), customer.getEmail(), customer.getAddress(), customer.getPhone());
                    return true;
                }
                else {
                    showError("The password is incorrect");
                    return false;
                }
            }
        }
        showError("The username is incorrect");
        return false;
    }

    public void switchToCustomerMainPage(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("TestCustomerMainPage1.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    protected void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Something error!!!");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
