package edu.sjsu.cs;

import edu.sjsu.cs.User.Admin;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import static edu.sjsu.cs.WelcomePageController.admins;

public class AdminLoginController extends SignUpController implements Initializable {
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
            this.switchToAdminMainPage(event);
        }

    }

   public boolean isValidLogin(String username, String password){
        for (Admin admin: admins){
            if (admin.getUsername().equals(username)){
                if (admin.getPassword().equals(password)){
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

    public void switchToAdminMainPage(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("AdminMainPage.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
    }
}
