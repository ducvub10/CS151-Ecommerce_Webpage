package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.sjsu.cs.User.Admin;
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
    protected static List<Admin> admins = new ArrayList();
    private static boolean adminsCreated = false;

    public List<Admin> createAdmin() {
        Admin admin1 = new Admin("kietquan", "Kiet@123", "kiet.quan@sjsu.edu", "(012) 345-6789", "Project Manager");
        Admin admin2 = new Admin("franklo", "Frank@123", "frank.lo@sjsu.edu", "(012) 345-6789", "Project Leader");
        Admin admin3 = new Admin("lenguyen", "Minh@123", "leminhtri.nguyen@sjsu.edu", "(012) 345-6789", "Team Member");
        Admin admin4 = new Admin("naiweiguan", "Naiwei@123", "naiwei.guan@sjsu.edu", "(012) 345-6789", "Team Member");
        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);
        admins.add(admin4);
        return admins;
    }

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

    public void switchToSignInPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignInPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        if (!adminsCreated) {
            createAdmin();
            adminsCreated = true;
        }

    }
}
