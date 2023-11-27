package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;



public class WelcomePageController implements Initializable {
    @FXML
    Label thing;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToCustomerSignIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSellerSignIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SellerLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminSignIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }


}
