package edu.sjsu.cs;

import java.io.IOException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.*;

import edu.sjsu.cs.Store_Properties.Store;
import edu.sjsu.cs.User.Product;
import edu.sjsu.cs.User.Seller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SellerRemovePageController implements Initializable{


    @FXML
    private Label removeText;

    @FXML
    private Button removeButton;

    @FXML
    private TextField itemName, itemID, itemDescription;

    @FXML
    private TextField itemPrice;

    @FXML
    private Button returnButton;
    @FXML
    private String url;
    private Product product;
    private Store store;
    private Seller seller;
    @FXML
    private Stage stage;
    private Scene scene;
    @FXML
    private Parent root;

    public void clickRemove(){
        String id = itemID.getText();
        String name = itemName.getText();
        String priceText = itemPrice.getText();
        String description = itemDescription.getText();
        double price = Double.parseDouble(priceText);
        Product item = new Product(id, name, price, description);
        Main.getStore().removeProduct(item);
        removeText.setText(name + " has been removed");
        System.out.println(name + " has been added to the Store!");
    }


    public void clickReturn()throws IOException{
        root = FXMLLoader.load(getClass().getResource("SellerMainPage.fxml"));

        stage = (Stage) returnButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void initialize(URL location, ResourceBundle resources) {

        this.store = Main.getStore();


    }


}