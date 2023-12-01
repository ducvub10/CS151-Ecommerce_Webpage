package edu.sjsu.cs;

import edu.sjsu.cs.User.Seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellerLoginController extends SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (this.isValidLogin(username, password)) {
            this.switchToSellerMainPage(event);
        }

    }

    public boolean isValidLogin(String username, String password){
        for (Seller seller: sellers){
            if (seller.getUsername().equals(username)){
                if (seller.getPassword().equals(password)){
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

    public void switchToSellerMainPage(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("SellerMainPage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToWelcomePage(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("WelcomePage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}

